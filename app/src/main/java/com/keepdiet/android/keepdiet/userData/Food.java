package com.keepdiet.android.keepdiet.userData;

import java.io.Serializable;

/**
 * Created by Liu Junlin on 2018/3/12.
 */

public class Food implements Serializable{
    private String foodTitle;
    private int caloryPerUnit;
    private double unitNumber;
    private String unitName;

    public Food(String foodTitle, int caloryPerUnit, double unitNumber, String unitName) {
        this.foodTitle = foodTitle;
        this.caloryPerUnit = caloryPerUnit;
        this.unitNumber = unitNumber;
        this.unitName = unitName;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public int getCaloryPerUnit() {
        return caloryPerUnit;
    }

    public void setCaloryPerUnit(int caloryPerUnit) {
        this.caloryPerUnit = caloryPerUnit;
    }

    public double getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(double unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getTotalCalory(){
        return ((int) (caloryPerUnit * unitNumber));
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodTitle='" + foodTitle + '\'' +
                ", caloryPerUnit=" + caloryPerUnit +
                ", unitNumber=" + unitNumber +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}
