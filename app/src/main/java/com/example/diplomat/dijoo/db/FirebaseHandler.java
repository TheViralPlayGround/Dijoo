package com.example.diplomat.dijoo.db;

import android.util.Log;

import com.example.diplomat.dijoo.AnotherOne;
import com.example.diplomat.dijoo.Dijoo;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.firebase.client.snapshot.KeyIndex;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Created by Diplomat on 2/27/2016.
 */


public class FirebaseHandler {

     String user_id;


    final String DIJOO_TABLE = "Dijoo";
    final String TITLE_COLUMN = "dijooTitle";
    final String CATEGORY_COLUMN = "dijooCategory";
    final String DIJOO_ID_COLUMN = "dijooID";
    final String UNITS_COLUMN = "dijooUnits";
    final String DIJOO_USERS = "dijooUsers";
    final String DIJOO_CHECKIN_HEAD = "DijooCommits";
    String currentDate;

    LinkedHashMap<String, Dijoo> allDijoos;

    public FirebaseHandler (String userID){
        this.user_id = userID;
    }


    public void addNewDijoo(Firebase firebase, String userID, String title, String category, String units) {

        Firebase dijoo = firebase.child(DIJOO_USERS).child(userID).push();
        Firebase nesss = dijoo.child(DIJOO_CHECKIN_HEAD);

       currentDate = new SimpleDateFormat("MMddyyyy", Locale.getDefault()).format(new Date());

        Dijoo addNewDijoo = new Dijoo(currentDate, title, category, units);

        dijoo.setValue(addNewDijoo);
    }



    public String getDijooByCategory(Firebase firebase, String userID ){

        String category ="";

        Firebase dijoo = firebase.child(DIJOO_USERS).child(userID);

        return category;

    }

    public void checkInDijoo(Firebase firebase, String userID, int value, String title){

        Firebase dijooFirebase = firebase.child(DIJOO_USERS).child(userID).child(title);

        Firebase checkInHead = dijooFirebase.child(DIJOO_CHECKIN_HEAD);

        currentDate = new SimpleDateFormat("MMddyyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("HHmmss", Locale.getDefault()).format(new Date());

        AnotherOne anotherOne = new AnotherOne(value,currentTime, "Feet");

        checkInHead.child(currentDate).push().setValue(value);
    }

    public void getUnits(Firebase firebase, String userID, String title){

        String units;

        Firebase dijooFirebase = firebase.child(DIJOO_USERS).child(userID).child(title);

        Query dijooQuer = dijooFirebase.orderByChild(title).equalTo(UNITS_COLUMN);

    }

    public void getDijooKeyOrder(Firebase fb, String userID){

        Firebase dijooFirebase = fb.child(DIJOO_USERS).child(userID);

        dijooFirebase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // do some stuff once
                for (DataSnapshot dijooSnapshot : snapshot.getChildren()) {
                    allDijoos = (LinkedHashMap<String, Dijoo>) dijooSnapshot.getValue();


                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        }

        );

    }



}
