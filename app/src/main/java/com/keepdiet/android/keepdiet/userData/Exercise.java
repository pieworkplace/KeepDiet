package com.keepdiet.android.keepdiet.userData;

import java.io.Serializable;

/**
 * Created by Liu Junlin on 2018/3/13.
 */

public class Exercise implements Serializable{
    private String exerciseTitle;
    private int caloryPerUnit;
    private double unitNumber;
    private String unitName;

    public Exercise(String exerciseTitle, int caloryPerUnit, double unitNumber, String unitName) {
        this.exerciseTitle = exerciseTitle;
        this.caloryPerUnit = caloryPerUnit;
        this.unitNumber = unitNumber;
        this.unitName = unitName;
    }

    public int getCaloryBurned(){
        return ((int)(caloryPerUnit * unitNumber));
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public int getCaloryPerUnit() {
        return caloryPerUnit;
    }

    public double getUnitNumber() {
        return unitNumber;
    }

    public String getUnitName() {
        return unitName;
    }
}
