# EasyDatastore
Easy way to handle shared preferences

It's pretty much retrofit for sharedprefs. 

You create an interface like:

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

Then create your Datastore like 

```
MyDatastore datastore = new DatastoreAdapter.Builder()
                .setSharedPrefs(PreferenceManager.getDefaultSharedPreferences(this))
                .build()
                .create(MyDatastore.class);
```


Then you can do 

```
datastore.bar().put("Hello World");

String bar = datastore.bar().get();
```

It now also supports all your basic types (String, int, boolean, float, long) as well as Objects via gson. 

I'm hoping to figure out a way to allow for edit chaining with a single apply, but I'm kind of stumped for a solution. 
