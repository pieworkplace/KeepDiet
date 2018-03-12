package com.keepdiet.android.keepdiet.userData;

import java.util.List;

/**
 * Created by Liu Junlin on 2018/3/12.
 */

public class User {
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

    public User(){
        //TODO change fake data
        caloryGoal = 2000;
        caloryBurned = 0;
        caloryConsumed = 0;
        caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        breakfastList = null;
        lunchList = null;
        dinnerList = null;
        snackList = null;
    }
}
