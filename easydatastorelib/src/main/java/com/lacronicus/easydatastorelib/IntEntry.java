package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

public class IntEntry extends PreferenceEntry<Integer> {

    public IntEntry(SharedPreferences preferences, String key, Integer defaultValue) {
        super(preferences, key, defaultValue);
    }

    @Override
    public Integer get() {
        return preferences.getInt(key, defaultValue);
    }

    @Override
    public Integer get(Integer runtimeDefaultValue) {
        return preferences.getInt(key, runtimeDefaultValue);
    }

    @Override
    public void put(Integer value) {
        preferences.edit().putInt(key, value).apply();
    }
}
