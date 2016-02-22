package com.example.diplomat.dijoo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.diplomat.dijoo.Dijoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diplomat on 2/10/2016.
 */
public class DBHandler extends SQLiteOpenHelper{

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //database values
    private static final String DATABASE_NAME      = "demoApp.db";
    private static final int DATABASE_VERSION      = 3;
    public static final String DIJOO_ID = "_id";

    //team table
    public static final String DIJOO_TABLE      = "Dijoo";
    public static final String DIJOO_TITLE       = "dijooTitle";
    public static final String DIJOO_CATEGORY   = "dijooCategory";
    public static final String DIJOO_UNITS      = "dijooUnits";
//    public static final String COLUMN_COACH     = "coach";
//    public static final String COLUMN_STADIUM   = "stadium";





    //*********FOR ALTERING AN EXISTING TABLE *******//

//    private static final String DATABASE_ALTER_DIJOO_TITLE = "ALTER TABLE "
//            + DIJOO_TABLE + " ADD COLUMN " + COLUMN_COACH + " string;";
//
//    private static final String DATABASE_ALTER_TEAM_2 = "ALTER TABLE "
//            + DIJOO_TABLE + " ADD COLUMN " + COLUMN_STADIUM + " string;";


    @Override
    public void onCreate(SQLiteDatabase db) {

        String DATABASE_CREATE_DIJOO = "CREATE TABLE "
                + DIJOO_TABLE + "(" + DIJOO_ID + " integer primary key autoincrement, "
                + DIJOO_TITLE + " string,"+ DIJOO_CATEGORY + " string," + DIJOO_UNITS + " string);";

        db.execSQL(DATABASE_CREATE_DIJOO);

        ContentValues contentValues = new ContentValues();

        contentValues.put(DIJOO_ID, 1);
        contentValues.put(DIJOO_TITLE, "ExampleDijooOne");
        contentValues.put(DIJOO_CATEGORY, "Ex. Category");
        contentValues.put(DIJOO_UNITS, "Dayzzz");

        db.insert(DIJOO_TABLE, null, contentValues);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if (oldVersion < 2) {
//            db.execSQL(DATABASE_ALTER_DIJOO_TITLE);
//        }
//        if (oldVersion < 3) {
//            db.execSQL(DATABASE_ALTER_TEAM_2);
//        }
    }



    public String getDijooTitle (Integer id, SQLiteDatabase db){

        String title = "EMPTFIELD";

        Cursor ccc = db.rawQuery("SELECT " + DIJOO_TITLE + " FROM " + DIJOO_TABLE + " WHERE " + DIJOO_ID + "= ?; ", new String[] {id.toString()});

        if(ccc != null && ccc.moveToFirst())
        {
        title = ccc.getString(ccc.getColumnIndex(DIJOO_TITLE));}



    return title;

    }

    public String getDijooCategory (Integer id, SQLiteDatabase db){

        String title = "EMPTFIELD";

        Cursor ccc = db.rawQuery("SELECT " + DIJOO_CATEGORY + " FROM " + DIJOO_TABLE + " WHERE " + DIJOO_ID + "= ?; ", new String[] {id.toString()});

        if(ccc != null && ccc.moveToFirst())
        {
            title = ccc.getString(ccc.getColumnIndex(DIJOO_CATEGORY));}


        return title;

    }

    public String getDijooUnits(Integer id, SQLiteDatabase db){
        String title = "EMPTFIELD";

        Cursor ccc = db.rawQuery("SELECT " + DIJOO_UNITS + " FROM " + DIJOO_TABLE + " WHERE " + DIJOO_ID + "= ?; ", new String[] {id.toString()});

        if(ccc != null && ccc.moveToFirst())
        {
            title = ccc.getString(ccc.getColumnIndex(DIJOO_UNITS));}


        return title;

    }

    public void addNewDijooToDB(String title, String category, String units, SQLiteDatabase db) {

        int unitID = 0;

        switch (units) {
            case "Feet":
                unitID = 1;
            case "Inches":
                unitID = 2;
            case "Minutes":
                unitID = 3;
            case "Ounces":
                unitID = 4;
            case "Pounds":
                unitID = 5;
            case "Times":
                unitID = 6;
        }

        int categoryID = 0;

        switch (category) {
            case "Health":
                categoryID = 1;
            case "Fitness":
                categoryID = 2;
            case "Business":
                categoryID = 3;
            case "Goals":
                categoryID = 4;
            case "Fun":
                categoryID = 5;
        }


        ContentValues cvalues = new ContentValues();

        cvalues.put(DIJOO_TITLE , title);
        cvalues.put(DIJOO_CATEGORY,category );
        cvalues.put(DIJOO_UNITS, units);


        db.insert(DIJOO_TABLE, null, cvalues);


    }

    public List<Dijoo> getDBDijoos(SQLiteDatabase db){
        List<Dijoo> dijooArray = new ArrayList<>();

        String dTitle;
        String dCategory;
        String dUnits;

        Cursor cursor = db.rawQuery("SELECT * FROM " + DIJOO_TABLE + ";", null);

        int numofdbrows = cursor.getCount() + 1;
        cursor.close();


        for(int i = 1; i<numofdbrows; i++) {
            dTitle = getDijooTitle(i, db);
            dCategory = getDijooCategory(i, db);
            dUnits = getDijooUnits(i, db);

            dijooArray.add(new Dijoo(dTitle, dCategory, null, null));
        }


        return dijooArray;
    }

    public ArrayList<Integer> getDBIDs(SQLiteDatabase db){

        ArrayList<Integer> allIDs = new ArrayList<>();
        Cursor cursor;


        String sqlToGetAllIDs = "SELECT * FROM " + DIJOO_TABLE + " WHERE ";

        return allIDs;
    }
}
