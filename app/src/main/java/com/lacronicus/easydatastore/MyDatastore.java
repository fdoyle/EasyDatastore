package com.lacronicus.easydatastore;

import com.lacronicus.easydatastorelib.Entry;
import com.lacronicus.easydatastorelib.Preference;

/**
 * Created by fdoyle on 7/10/15.
 */
public interface MyDatastore {

    @Preference("foo")
    Entry foo();

    @Preference("bar")
    Entry bar();
}
