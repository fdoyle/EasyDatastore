package com.lacronicus.easydatastore;

import com.lacronicus.easydatastorelib.BooleanEntry;
import com.lacronicus.easydatastorelib.IntEntry;
import com.lacronicus.easydatastorelib.ObjectEntry;
import com.lacronicus.easydatastorelib.StringEntry;
import com.lacronicus.easydatastorelib.Preference;

/**
 * Created by fdoyle on 7/10/15.
 */
public interface MyDatastore {

    @Preference("foo")
    StringEntry foo();

    @Preference("bar")
    StringEntry bar();

    @Preference("baz")
    IntEntry myInt();

    @Preference("boolean")
    BooleanEntry myBoolean();

    @Preference("object")
    ObjectEntry<MyModel> myModel();
}
