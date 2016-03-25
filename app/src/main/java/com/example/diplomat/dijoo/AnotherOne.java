package com.example.diplomat.dijoo;

/**
 * Created by Diplomat on 3/4/2016.
 */
public class AnotherOne {

    String commitDate;
    int valueString;
    String time;

    public AnotherOne(){

    }

    public AnotherOne (int valueString, String time, String date){
        this.valueString = valueString;
        this.time = time;
        this.commitDate = date;

    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    public int getValueString() {
        return valueString;
    }

    public void setValueString(int valueString) {
        this.valueString = valueString;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
