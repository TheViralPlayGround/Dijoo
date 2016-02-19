package com.example.diplomat.dijoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.diplomat.dijoo.db.DBHandler;

/**
 * Created by Diplomat on 2/14/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected static DBHandler dbHandler;
    protected  Context context;
    protected static SQLiteDatabase database;

    Window window;


    @Override
    protected void onPause() {

        // TODO close database

        dbHandler.close();

        super.onPause();

    }

    @Override
    protected void onResume() {

        super.onResume();
        // TODO open database

        dbHandler.getReadableDatabase();

    }

    @Override
    protected void onStop(){
        super.onStop();


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

}
