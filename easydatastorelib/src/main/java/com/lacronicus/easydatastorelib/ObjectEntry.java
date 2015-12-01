package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by fdoyle on 7/10/15.
 */
public class ObjectEntry<T> {
    SharedPreferences preferences;
    String key;
    Gson gson;
    Type type;
    public ObjectEntry( Type type, Gson gson, SharedPreferences preferences, String key) {
        this.preferences = preferences;
        this.key = key;
        this.gson = gson;
        this.type = type;
    }

    public T get() {
        String json = preferences.getString(key, null);
        return gson.fromJson(json, type);
    }

    public void put(T value) {
        preferences.edit().putString(key, gson.toJson(value)).apply();
    }
}
