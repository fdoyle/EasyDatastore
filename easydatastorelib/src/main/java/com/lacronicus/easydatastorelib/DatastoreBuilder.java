package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;

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
            Preference annotation = method.getAnnotation(Preference.class);
            String key = annotation.value();
            String defaultString = annotation.defaultString();
            boolean defaultBoolean = annotation.defaultBoolean();
            int defaultInt = annotation.defaultInt();
            long defaultLong = annotation.defaultLong();
            float defaultFloat = annotation.defaultFloat();

            if (method.getReturnType().equals(StringEntry.class)) {
                return new StringEntry(preferences, key, defaultString);
            } else if (method.getReturnType().equals(FloatEntry.class)) {
                return new FloatEntry(preferences, key, defaultFloat);
            } else if (method.getReturnType().equals(LongEntry.class)) {
                return new LongEntry(preferences, key, defaultLong);
            } else if (method.getReturnType().equals(IntEntry.class)) {
                return new IntEntry(preferences, key, defaultInt);
            } else if (method.getReturnType().equals(BooleanEntry.class)) {
                return new BooleanEntry(preferences, key, defaultBoolean);
            } else if (method.getReturnType().equals(ObjectEntry.class)) {
                if (method.getGenericReturnType() instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) method.getGenericReturnType();
                    Class<?> type = (Class) parameterizedType.getActualTypeArguments()[0];
                    return new ObjectEntry<>(preferences, key, gson, type);
                }
                throw new RuntimeException("ObjectEntries must have a parameter");
            } else {
                return null;
            }
        }
    }
}
