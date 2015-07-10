package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

/**
 * Created by fdoyle on 7/10/15.
 */
public class FloatEntry {
    SharedPreferences preferences;
    String key;

    public FloatEntry(SharedPreferences preferences, String key) {
        this.preferences = preferences;
        this.key = key;
    }

    public float get(float def) {
        return preferences.getFloat(key, def);
    }

    public void put(float value) {
        preferences.edit().putFloat(key, value).commit();
    }
}
