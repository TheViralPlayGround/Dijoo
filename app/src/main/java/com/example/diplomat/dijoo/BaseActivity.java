package com.example.diplomat.dijoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.diplomat.dijoo.db.DBHandler;
import com.firebase.client.Firebase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Diplomat on 2/14/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected static DBHandler dbHandler;
    protected  Context context;
    protected static SQLiteDatabase database;
    Firebase dijooFireBase;


    public String currentDate = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(new Date());



    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
    }


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

        dbHandler.close();
        super.onStop();


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

}
