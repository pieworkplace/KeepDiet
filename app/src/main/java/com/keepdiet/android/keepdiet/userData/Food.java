package com.keepdiet.android.keepdiet.userData;

/**
 * Created by Liu Junlin on 2018/3/12.
 */

public class Food {
    private String foodTitle;
    private int caloryPerUnit;
    private int unitNumber;
    private String unitName;

    public Food(String foodTitle, int caloryPerUnit, int unitNumber, String unitName) {
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

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
