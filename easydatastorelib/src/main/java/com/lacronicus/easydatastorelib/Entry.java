package com.lacronicus.easydatastorelib;

import android.content.SharedPreferences;

/**
 * Created by fdoyle on 7/10/15.
 */
public class Entry {
    SharedPreferences preferences;
    String key;
    public Entry(SharedPreferences preferences, String key) {
        this.preferences = preferences;
        this.key = key;
    }

    public String get() {
        return preferences.getString(key, null);
    }

    public void put(String value) {
        preferences.edit().putString(key, value).commit();
    }
}
