# EasyDatastore
Every app I write has a wrapper object responsible for pushing/pulling data to/from sharedprefs. Usually, it's mostly copied from the last time I wrote one, which usually led to mismatched keys for reading and writing, or two writes having the same key, stupid stuff like that. 

With this setup, working with sharedprefs becomes pretty trivial and, because it's all based on an interface, mocking it out is easy too (thanks Retrofit). 

Your interface should look like:

```
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

```

Then create your "Datastore" like 

```
MyDatastore datastore = new DatastoreBuilder(PreferenceManager.getDefaultSharedPreferences(context))
                .create(MyDatastore.class);
```


Then you can do 

```
datastore.bar().put("Hello World");

String bar = datastore.bar().get();
```

It now also supports all your basic types (String, int, boolean, float, long) as well as Objects via gson. 

I'm hoping to figure out a way to allow for edit chaining with a single apply, but I'm kind of stumped for a solution. 
