package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

import com.google.gson.Gson;

public class ObjectEntry<K> extends PreferenceEntry<Object> {

    Gson gson;
    Class<K> type;

    public ObjectEntry(SharedPreferences preferences, String key, Gson gson, Class<K> type) {
        super(preferences, key, null);
        this.gson = gson;
        this.type = type;
    }

    @Override
    public K get() {
        String json = preferences.getString(key, null);
        return gson.fromJson(json, type);
    }

    @Override
    public K get(Object runtimeDefaultValue) {
        throw new NoSuchMethodError("get() with default value not implemented for ObjectEntry");
    }

    @Override
    public void put(Object value) {
        preferences.edit().putString(key, gson.toJson(value)).apply();
    }
}