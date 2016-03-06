package com.example.diplomat.dijoo.db;

import com.example.diplomat.dijoo.AnotherOne;
import com.example.diplomat.dijoo.Dijoo;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
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

        Dijoo addNewDijoo = new Dijoo(currentDate, category, units, title);

        dijoo.setValue(addNewDijoo);
//        dijoo = firebase.child(DIJOO_USERS).child(userID).child(title).child(currentDate)


        nesss.child(currentDate).push().setValue(checki2n);
        nesss.child(currentDate).push().setValue(checkin);
        nesss.child(currentDate).push().setValue(checki3n);
        nesss.child(currentDate).push().setValue(checki244n);


    }



    public void getDijooByCategory(Firebase firebase, String userID, String categoryName){

        Firebase dijoo = firebase.child(DIJOO_USERS).child(userID);

    }

    public void checkInDijoo(Firebase firebase, String userID, String value, String title){

        Firebase dijooFirebase = firebase.child(DIJOO_USERS).child(userID).child(title);

        Firebase checkInHead = dijooFirebase.child(DIJOO_CHECKIN_HEAD);

        currentDate = new SimpleDateFormat("MMddyyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("HHmmss", Locale.getDefault()).format(new Date());

        AnotherOne anotherOne = new AnotherOne(value,currentTime);

        checkInHead.child(currentDate).push().setValue(value);
    }

    public String getUnits(Firebase firebase, String userID, String title){

        String units;

        Firebase dijooFirebase = firebase.child(DIJOO_USERS).child(userID).child(title);

        Query dijooQuer = dijooFirebase.orderByChild(title).equalTo(UNITS_COLUMN);

        dijooQuer.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                System.out.println(snapshot.getKey());
            }


        return units;
    }
}