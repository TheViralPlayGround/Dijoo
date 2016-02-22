package com.example.diplomat.dijoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diplomat on 1/21/2016.
 */
public class Dijoo {

    public String dijooTitle;
    public String dijooCategory;
    public String dijooUnits;
    public String checkInID;
    public int dijooPic;
    public static ArrayList<Dijoo> newDijoo = new ArrayList<>();

    public  Dijoo (String dijooTitle, String category, String units, String checkInID){
        this.dijooTitle = dijooTitle;
        this.dijooCategory = category;
        this.dijooUnits = units;
        this.checkInID = checkInID;
    }

    public Dijoo (String title, String Count, int DijooPic){
        this.dijooTitle = title;
        this.dijooCategory = Count;
        this.dijooPic = DijooPic;
    }


    public static ArrayList<Dijoo> getUsers(int numUsers) {
        ArrayList<Dijoo> users = new ArrayList<Dijoo>();

        for(int i = 0; i <numUsers; i++)
        users.add(new Dijoo("Dijoo Item Title", "Dijoo Item Category", null, null));
        return users;
    }

    public static ArrayList<Dijoo> addDijoo(String title, String category, String units, String location){

        newDijoo.add(new Dijoo(title, category, units, location));
        return newDijoo;

    }

    private List dijoos;

    private void initializeData(){
        dijoos = new ArrayList<>();
        dijoos.add(new Dijoo("Emma Wilson", "23 years old", R.drawable.check_off_dark));
        dijoos.add(new Dijoo("Lavery Maiss", "25 years old", R.drawable.cancel_white));
        dijoos.add(new Dijoo("Lillie Watts", "35 years old", R.drawable.dipset_logo));
    }


}
