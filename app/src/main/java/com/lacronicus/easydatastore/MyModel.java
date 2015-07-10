package com.lacronicus.easydatastore;

/**
 * Created by fdoyle on 7/10/15.
 */
public class MyModel {
    String derp;
    int foo;

    public MyModel(String derp, int foo) {
        this.derp = derp;
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "derp='" + derp + '\'' +
                ", foo=" + foo +
                '}';
    }
}
