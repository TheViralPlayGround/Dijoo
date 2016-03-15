package com.example.diplomat.dijoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.diplomat.dijoo.db.FirebaseHandler;
import com.firebase.client.Firebase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Diplomat on 2/14/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected  Context context;
    protected static Firebase dijooFireBase;
    protected static FirebaseHandler fbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
    }


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

    @Override
    protected void onStop(){

        super.onStop();


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

}
