package com.example.diplomat.dijoo.db;

import com.example.diplomat.dijoo.AnotherOne;
import com.example.diplomat.dijoo.Dijoo;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

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
    final String DIJOO_ALL = "allDijoos";
    final String DIJOO_CHECKIN_HEAD = "DijooCommits";
    public int dijooDailyTotal;
    ArrayList<Integer> allValues;

    LinkedHashMap<String, Dijoo> allDijoos;

    public FirebaseHandler(){
    }

    public FirebaseHandler (String userID){
        this.user_id = userID;
    }


    public void addNewDijoo(Firebase firebase, String userID, String title, String category, String units) {

        Firebase dijoo = firebase.child(DIJOO_ALL).push();

        String  currentDate = new SimpleDateFormat("MMddyyyy", Locale.getDefault()).format(new Date());

        Dijoo addNewDijoo = new Dijoo(userID,currentDate,title,category,units,0);

        dijoo.setValue(addNewDijoo);
    }



    public String getDijooByCategory(Firebase firebase, String userID ){

        String category ="";

        Firebase dijoo = firebase.child(DIJOO_USERS).child(userID);

        return category;

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

        );}

        public ArrayList<Integer> getDailyTotalForDijoo(final Firebase firebase, final String key){

            final String today = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(new Date());


            Firebase ref = firebase.child("CheckIns");

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                        AnotherOne post = postSnapshot.getValue(AnotherOne.class);
                        if(post.getItemKey().equals(key)  && post.getCommitDate().equals(today)){

                            allValues.add(post.getValueString());

                        }

                    }
                }
                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    System.out.println("The read failed: " + firebaseError.getMessage());
                }
            });

            return allValues;

        }

        public void updateDailyTotals(Firebase fb, String key){

        int newTotal = 0;
        Firebase checkInRef = fb.child("CheckIns").child(key);

        ArrayList<Integer> valueArray =  getDailyTotalForDijoo(fb, key);

            for (int i= 0; i <valueArray.size(); i++){
                newTotal = newTotal + valueArray.get(i);
            }

        Map<String, Object> dailyTotal = new HashMap<String, Object>();


        dailyTotal.put("dijooDailyTotal", newTotal);
    }

    }




