package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

/**
 * Created by fdoyle on 7/10/15.
 */
public class BooleanEntry {
    SharedPreferences preferences;
    String key;
    public BooleanEntry(SharedPreferences preferences, String key) {
        this.preferences = preferences;
        this.key = key;
    }

    public boolean get(boolean def) {
        return preferences.getBoolean(key, def);
    }

    public void put(boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }
}
