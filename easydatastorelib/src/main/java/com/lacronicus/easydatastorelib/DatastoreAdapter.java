package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 package com.derp.easyprefslib;

 import android.content.SharedPreferences;

 import java.lang.reflect.InvocationHandler;
 import java.lang.reflect.Method;
 import java.lang.reflect.Proxy;

 /**
 * Created by fdoyle on 7/10/15.
 */
public class DatastoreAdapter {
    SharedPreferences preferences;

    public DatastoreAdapter(SharedPreferences preferences) {
        this.preferences = preferences;
    }


    public <T> T create(Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new DatastoreHandler(preferences));
    }


    public static class Builder {
        SharedPreferences preferences;

        public Builder() {

        }

        public Builder setSharedPrefs(SharedPreferences preferences) {
            this.preferences = preferences;
            return this;
        }

        public DatastoreAdapter build() {
            return new DatastoreAdapter(preferences);
        }
    }

    private class DatastoreHandler implements InvocationHandler {
        SharedPreferences preferences;

        public DatastoreHandler(SharedPreferences preferences) {
            this.preferences = preferences;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String key = method.getAnnotation(Preference.class).value();
            return new Entry(preferences, key);
        }
    }
}
