package com.example.diplomat.dijoo;

import java.util.ArrayList;

/**
 * Created by Diplomat on 1/21/2016.
 */
public class Dijoo {

    public String dijooTitle;
    public String dijooCategory;
    public String dijooUnits;
    public String dijooCreationDate;
    public String dijooUser;
    public String dijOOtest;
    public int dijooDailyTotal;
    public int dijooPic;
    public static ArrayList<Dijoo> newDijoo = new ArrayList<>();

    public  Dijoo (String dijooUser, String currentDate, String dijooTitle, String category, String units, int dailyTotal){
        this.dijooUser = dijooUser;
        this.dijooTitle = dijooTitle;
        this.dijooCategory = category;
        this.dijooUnits = units;
        this.dijooCreationDate = currentDate;
        this.dijooDailyTotal = dailyTotal;
    }

    public Dijoo(){}

    public static ArrayList<Dijoo> getUsers(int numUsers) {
        ArrayList<Dijoo> users = new ArrayList<Dijoo>();

        for(int i = 0; i <numUsers; i++)
        users.add(new Dijoo("Dijoo User", "Dijoo Item Title", "Dijoo Item Category", null, null, 0));
        return users;
    }

    public static ArrayList<Dijoo> addDijoo(String dijooUser, String title, String category, String units, String location){

        newDijoo.add(new Dijoo(dijooUser, title, category, units, location, 0));
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
        return dijooCreationDate;
    }

    public void setCurrentDate(String currentDate) {
        this.dijooCreationDate = currentDate;
    }

    public int getDijooPic() {
        return dijooPic;
    }

    public void setDijooPic(int dijooPic) {
        this.dijooPic = dijooPic;
    }

    public String getDijooUser(){return dijooUser;}

    public int getDijooDailyTotal() {
        return dijooDailyTotal;
    }

    public void setDijooDailyTotal(int dijooDailyTotal) {
        this.dijooDailyTotal = dijooDailyTotal;
    }

}
