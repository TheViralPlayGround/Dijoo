package com.example.diplomat.dijoo;

import java.util.ArrayList;

/**
 * Created by Diplomat on 1/21/2016.
 */
public class Dijoo {

    public String dijooTitle;
    public String dijooCategory;
    public String dijooUnits;
    public String currentDate;
    public int dijooPic;
    public static ArrayList<Dijoo> newDijoo = new ArrayList<>();

    public  Dijoo (String currentDate, String dijooTitle, String category, String units){
        this.dijooTitle = dijooTitle;
        this.dijooCategory = category;
        this.dijooUnits = units;
        this.currentDate = currentDate;
    }

    public Dijoo (String title, String count, int dijooPic){
        this.dijooTitle = title;
        this.dijooCategory = count;
        this.dijooPic = dijooPic;
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

    public String getDijooTitle() {
        return dijooTitle;
    }

    public void setDijooTitle(String dijooTitle) {
        this.dijooTitle = dijooTitle;
    }

    public String getDijooCategory() {
        return dijooCategory;
    }

    public void setDijooCategory(String dijooCategory) {
        this.dijooCategory = dijooCategory;
    }

    public String getDijooUnits() {
        return dijooUnits;
    }

    public void setDijooUnits(String dijooUnits) {
        this.dijooUnits = dijooUnits;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public int getDijooPic() {
        return dijooPic;
    }

    public void setDijooPic(int dijooPic) {
        this.dijooPic = dijooPic;
    }
}
