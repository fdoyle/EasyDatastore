package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

public class BooleanEntry extends PreferenceEntry<Boolean> {

    public BooleanEntry(SharedPreferences preferences, String key, Boolean defaultValue) {
        super(preferences, key, defaultValue);
    }

    @Override
    public Boolean get() {
        return preferences.getBoolean(key, defaultValue);
    }

    @Override
    public Boolean get(Boolean runtimeDefaultValue) {
        return preferences.getBoolean(key, runtimeDefaultValue);
    }

    @Override
    public void put(Boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }
}
