# EasyDatastore
Easy way to handle shared preferences


It's pretty much retrofit for your shared preferences

You create an interface like:

```
public interface MyDatastore {

    @Preference("foo")
    Entry foo();

    @Preference("bar")
    Entry bar();
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

In the future, it will support things other than strings, like ints and booleans. Maybe someday it'll support plain objects through gson. 
