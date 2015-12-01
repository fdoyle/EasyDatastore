package com.lacronicus.easydatastore;

import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.lacronicus.easydatastorelib.DatastoreBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyDatastore datastore = new DatastoreBuilder(PreferenceManager.getDefaultSharedPreferences(this))
                .create(MyDatastore.class);

        datastore.bar().put("Hello World");
        String bar = datastore.bar().get();
        Log.d("APP", bar);
        Toast.makeText(this, bar, Toast.LENGTH_SHORT).show();

        datastore.myInt().put(2);
        int myInt = datastore.myInt().get(-1);
        Log.d("APP", "" + myInt);

        datastore.myFloat().put(2.4f);
        float myFloat = datastore.myFloat().get(-1);
        Log.d("APP", "" + myFloat);

        datastore.myLong().put(Long.MAX_VALUE);
        long myLong = datastore.myLong().get(-1);
        Log.d("APP", "" + myLong);

        datastore.myBoolean().put(true);
        boolean mybool = datastore.myBoolean().get(false);
        Log.d("APP", "" + mybool);

        MyModel model = new MyModel("derp", 42);
        datastore.myModel().put(model);
        MyModel pulledModel = datastore.myModel().get();
        Log.d("APP", pulledModel.toString());

        MyModel listModel1 = new MyModel("foo", 1);
        MyModel listModel2 = new MyModel("foo", 2);
        MyModel listModel3 = new MyModel("foo", 3);
        List<MyModel> models = Arrays.asList(listModel1, listModel2, listModel3);
        datastore.myModelList().put(models);
        models = datastore.myModelList().get();
        for(MyModel m : models) {
            Log.d("APP", m.toString());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
