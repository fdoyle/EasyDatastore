package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

public class FloatEntry extends PreferenceEntry<Float> {

    public FloatEntry(SharedPreferences preferences, String key, Float defaultValue) {
        super(preferences, key, defaultValue);
    }

    @Override
    public Float get() {
        return preferences.getFloat(key, defaultValue);
    }

    @Override
    public Float get(Float runtimeDefaultValue) {
        return preferences.getFloat(key, runtimeDefaultValue);
    }

    @Override
    public void put(Float value) {
        preferences.edit().putFloat(key, value).apply();
    }
}
