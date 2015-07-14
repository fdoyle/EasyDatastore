package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by fdoyle on 7/10/15.
 */
public class ObjectEntry<T> {
    SharedPreferences preferences;
    String key;
    Gson gson;
    Class<T> type;
    public ObjectEntry(Class<T> type, Gson gson, SharedPreferences preferences, String key) {
        this.preferences = preferences;
        this.key = key;
        this.type = type;
        this.gson = gson;
    }

    public T get() {
        String json = preferences.getString(key, null);
        return gson.fromJson(json, type);
    }

    public void put(T value) {
        preferences.edit().putString(key, gson.toJson(value)).apply();
    }
}
