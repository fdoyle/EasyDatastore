package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

public class StringEntry extends PreferenceEntry<String> {

    public StringEntry(SharedPreferences preferences, String key, String defaultValue) {
        super(preferences, key, defaultValue);
    }

    @Override
    public String get() {
        return preferences.getString(key, defaultValue);
    }

    @Override
    public String get(String runtimeDefaultValue) {
        return preferences.getString(key, runtimeDefaultValue);
    }

    @Override
    public void put(String value) {
        preferences.edit().putString(key, value).apply();
    }
}
