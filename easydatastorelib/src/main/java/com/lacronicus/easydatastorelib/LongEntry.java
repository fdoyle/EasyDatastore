package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

public class LongEntry extends PreferenceEntry<Long> {

    public LongEntry(SharedPreferences preferences, String key, Long defaultValue) {
        super(preferences, key, defaultValue);
    }

    @Override
    public Long get() {
        return preferences.getLong(key, defaultValue);
    }

    @Override
    public Long get(Long runtimeDefaultValue) {
        return preferences.getLong(key, runtimeDefaultValue);
    }

    @Override
    public void put(Long value) {
        preferences.edit().putLong(key, value).apply();
    }
}