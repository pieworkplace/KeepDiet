package com.keepdiet.android.keepdiet.userData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu Junlin on 2018/3/12.
 */

public class User implements Serializable{
    //diary related
    //overall
    private int caloryGoal;
    private int caloryConsumed;
    private int caloryBurned;
    private int caloryRemaining;
    //meals
    private List<Food> breakfastList;
    private List<Food> lunchList;
    private List<Food> dinnerList;
    private List<Food> snackList;

    public int getCaloryGoal() {
        return caloryGoal;
    }

    public void setCaloryGoal(int caloryGoal) {
        this.caloryGoal = caloryGoal;
    }

    public int getCaloryConsumed() {
        return caloryConsumed;
    }

    public void setCaloryConsumed(int caloryConsumed) {
        this.caloryConsumed = caloryConsumed;
    }

    public int getCaloryBurned() {
        return caloryBurned;
    }

    public void setCaloryBurned(int caloryBurned) {
        this.caloryBurned = caloryBurned;
    }

    public int getCaloryRemaining() {
        return caloryRemaining;
    }

    public void setCaloryRemaining(int caloryRemaining) {
        this.caloryRemaining = caloryRemaining;
    }

    public List<Food> getBreakfastList() {
        return breakfastList;
    }


    public List<Food> getLunchList() {
        return lunchList;
    }


    public List<Food> getDinnerList() {
        return dinnerList;
    }

    public List<Food> getSnackList() {
        return snackList;
    }

    public void addBreakfastList(Food food){
        breakfastList.add(food);
        caloryConsumed += food.getTotalCalory();
        caloryRemaining -= food.getTotalCalory();
    }

    public void addLunchList(Food food){
        lunchList.add(food);
        caloryConsumed += food.getTotalCalory();
        caloryRemaining -= food.getTotalCalory();
    }

    public void addDinnerList(Food food){
        dinnerList.add(food);
        caloryConsumed += food.getTotalCalory();
        caloryRemaining -= food.getTotalCalory();
    }

    public void addSnackList(Food food){
        snackList.add(food);
        caloryConsumed += food.getTotalCalory();
        caloryRemaining -= food.getTotalCalory();
    }


    public User() {
        //TODO change fake data
        caloryGoal = 2000;
        caloryBurned = 0;
        caloryConsumed = 0;
        caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;

        breakfastList = new ArrayList<Food>();
        lunchList = new ArrayList<Food>();
        dinnerList = new ArrayList<Food>();
        snackList = new ArrayList<Food>();
//
//        breakfastList.add(new Food("Fried Chicken", 200, 1, "pound"));
//        breakfastList.add(new Food("Fried Chicken", 200, 1, "pound"));
//        dinnerList.add(new Food("Fried Chicken", 200, 1, "pound"));
    }
}
