package com.lacronicus.easydatastorelib;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by fdoyle on 7/10/15.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Preference {
    String value();
}
