package com.example.diplomat.dijoo;

import java.util.ArrayList;

/**
 * Created by Diplomat on 1/21/2016.
 */
public class Dijoo {

    public String dijooTitle;
    public String dijooSubtitle;
    public String dijooUnits;
    public String dijooLocation;
    public static ArrayList<Dijoo> newDijoo = new ArrayList<>();

    public  Dijoo (String dijooTitle, String currentValue, String units, String location){
        this.dijooTitle = dijooTitle;
        this.dijooSubtitle = currentValue;
        this.dijooUnits = units;
        this.dijooLocation = location;
    }


    public static ArrayList<Dijoo> getUsers(int numUsers) {
        ArrayList<Dijoo> users = new ArrayList<Dijoo>();

        for(int i = 0; i <numUsers; i++)
        users.add(new Dijoo("Dijoo Item Title", "Dijoo Item SubTitle", null, null));
        return users;
    }

    public static ArrayList<Dijoo> addDijoo(String title, String category, String units, String location){

        newDijoo.add(new Dijoo(title, category, units, location));
        return newDijoo;

    }

}
