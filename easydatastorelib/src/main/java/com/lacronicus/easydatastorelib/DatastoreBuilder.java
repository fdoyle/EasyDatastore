package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * Created by fdoyle on 7/10/15.
 */
public class DatastoreBuilder {
    SharedPreferences preferences;
    Gson gson;

    public DatastoreBuilder(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public DatastoreBuilder setGson(Gson gson) {
        this.gson = gson;
        return this;
    }

    public <T> T create(Class<T> service) {
        if(gson == null) {
            gson = new Gson();
        }
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new DatastoreHandler(preferences, gson));
    }

    private static class DatastoreHandler implements InvocationHandler {
        SharedPreferences preferences;
        Gson gson;

        public DatastoreHandler(SharedPreferences preferences, Gson gson) {
            this.preferences = preferences;
            this.gson = gson;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String key = method.getAnnotation(Preference.class).value();
            if (method.getReturnType().equals(StringEntry.class)) {
                return new StringEntry(preferences, key);
            } else if (method.getReturnType().equals(FloatEntry.class)) {
                return new FloatEntry(preferences, key);
            } else if (method.getReturnType().equals(LongEntry.class)) {
                return new LongEntry(preferences, key);
            } else if (method.getReturnType().equals(IntEntry.class)) {
                return new IntEntry(preferences, key);
            } else if (method.getReturnType().equals(BooleanEntry.class)) {
                return new BooleanEntry(preferences, key);
            } else if (method.getReturnType().equals(ObjectEntry.class)) {
                if(method.getGenericReturnType() instanceof ParameterizedType) {
                    ParameterizedType containerType = (ParameterizedType) method.getGenericReturnType();
                    Type typeArgument = containerType.getActualTypeArguments()[0];
                    return new ObjectEntry<>(typeArgument, gson, preferences, key);
                }
                throw new RuntimeException("ObjectEntries must have a parameter");
            } else {
                return null;
            }
        }
    }
}
