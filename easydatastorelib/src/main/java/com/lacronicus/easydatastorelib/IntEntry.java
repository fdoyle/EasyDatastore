package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

/**
 * Created by fdoyle on 7/10/15.
 */
public class IntEntry {
    SharedPreferences preferences;
    String key;

    public IntEntry(SharedPreferences preferences, String key) {
        this.preferences = preferences;
        this.key = key;
    }

    public int get(int def) {
        return preferences.getInt(key, def);
    }


    public void put(int value) {
        preferences.edit().putInt(key, value).apply();
    }
}
