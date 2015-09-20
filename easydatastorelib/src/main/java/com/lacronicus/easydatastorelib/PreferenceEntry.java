package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

public abstract class PreferenceEntry<T> {

    SharedPreferences preferences;
    String key;
    T defaultValue;

    protected PreferenceEntry(SharedPreferences preferences, String key, T defaultValue) {
        this.preferences = preferences;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public abstract T get();

    public abstract void put(T value);

    public abstract T get(T runtimeDefaultValue);

}