package com.example.diplomat.dijoo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Diplomat on 2/14/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected static DBHandler DijooDatabase;
    protected  Context context;

    @Override
    protected void onPause() {

        // TODO close database

        super.onPause();
    }

    @Override
    protected void onResume() {

        super.onResume();

        // TODO open database

    }

}
