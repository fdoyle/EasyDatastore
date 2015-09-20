# EasyDatastore

```
compile 'com.lacronicus:easydatastorelib:+'
latest: 
compile 'com.lacronicus:easydatastorelib:1.0.3'
```

Every app I write has a wrapper object responsible for pushing/pulling data to/from sharedprefs. Usually, it's mostly copied from the last time I wrote one, which often leads to mismatched keys for reading and writing, or two writes having the same key, stupid stuff like that. No more. 

With this setup, working with sharedprefs becomes pretty trivial and, because it's all based on an interface, mocking it out is easy too (thanks Retrofit). 

Your interface should look like:

```java
public interface MyDatastore {

    @Preference("foo")
    StringEntry foo();

    @Preference(value = "bar", defaultString = "foo")
    StringEntry bar();

    @Preference("baz")
    IntEntry myInt();

    @Preference("boolean")
    BooleanEntry myBoolean();

    @Preference("object")
    ObjectEntry<MyModel> myModel();
}

```

Then create your "Datastore" like 

```java
MyDatastore datastore = new DatastoreBuilder(PreferenceManager.getDefaultSharedPreferences(context))
                .create(MyDatastore.class);
```


Then you can do 

```java
datastore.bar().put("Hello World");

String bar = datastore.bar().get();
```

It now also supports all your basic types (String, int, boolean, float, long) as well as Objects via gson.
 
## Dynamic default values
 In Java it's only possible to use constant values as attribute values in annotations. 
 To overcome this limitation, you can now call `get(someNonconstantValue)` for each type of entries in addition to the usual `get()` that uses the default value you provide in `Preference(value = "bar", defaultString = "foo")`.

Todo:
multiple changes in a single apply?
throw exception if multiple methods share the same key?
