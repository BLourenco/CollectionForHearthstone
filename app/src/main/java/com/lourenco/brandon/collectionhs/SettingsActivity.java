package com.lourenco.brandon.collectionhs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Brandon on 2016-03-26.
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Settings");

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();



    }


}
