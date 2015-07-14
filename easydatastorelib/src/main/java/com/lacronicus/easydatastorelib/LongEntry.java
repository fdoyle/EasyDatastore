package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

/**
 * Created by fdoyle on 7/10/15.
 */
public class LongEntry {
    SharedPreferences preferences;
    String key;
    public LongEntry(SharedPreferences preferences, String key) {
        this.preferences = preferences;
        this.key = key;
    }

    public Long get(long def) {
        return preferences.getLong(key, def);
    }

    public void put(long value) {
        preferences.edit().putLong(key, value).apply();
    }
}
