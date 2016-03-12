package com.example.diplomat.dijoo.db;

import android.database.Cursor;

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
import java.util.List;
import java.util.Locale;

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


    public FirebaseHandler (String userID){
        this.user_id = userID;
    }


    public void addNewDijoo(Firebase firebase, String userID, String title, String category, String units) {

        Firebase dijoo = firebase.child(DIJOO_USERS).child(userID).child(title);
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


//
//    public List<String> getDijooTitles(Firebase firebase, final String user_id  ){
//
//        final Firebase dijooBase = firebase;
//
//        dijooBase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dijooSnapshot) {
//
//                Dijoo dijooArray =  dijooSnapshot.getValue(Dijoo.class);
//                final long numofdbrows = dijooSnapshot.getChildrenCount();
//
//                final Query query = dijooBase.orderByChild(user_id);
//
//                query.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for(int i = 0; i <numofdbrows; i++){
//                            
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(FirebaseError firebaseError) {
//
//                    }
//                });
//
//
//
//            }
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//            }
//        });
//
//        List<Dijoo> dijooArray = new ArrayList<>();
//
//        String dTitle;
//        String dCategory;
//        String dUnits;
//
//        Cursor cursor = db.rawQuery("SELECT * FROM " + DIJOO_TABLE + ";", null);
//        cursor.close();
//
//
//        for(int i = 1; i<numofdbrows; i++) {
//            dTitle = getDijooTitle(i, db);
//            dCategory = getDijooCategory(i, db);
//            dUnits = getDijooUnits(i, db);
//
//            dijooArray.add(new Dijoo(dTitle, dCategory, null, null));
//        }
//
//
//        return dijooArray;
//
//}

    }
