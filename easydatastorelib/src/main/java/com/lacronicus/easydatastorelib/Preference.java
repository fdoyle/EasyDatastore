package com.lacronicus.easydatastorelib;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Preference {
    String value();
    String defaultString() default "";
    boolean defaultBoolean() default false;
    int defaultInt() default 0;
    long defaultLong() default 0;
    float defaultFloat() default 0.0f;
}
