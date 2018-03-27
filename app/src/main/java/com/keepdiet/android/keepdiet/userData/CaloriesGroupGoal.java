package com.keepdiet.android.keepdiet.userData;

/**
 * Created by Liu Junlin on 2018/3/26.
 */

public class CaloriesGroupGoal extends GroupGoal {
    private boolean lessThan;
    private int caloriesGoal;

    public CaloriesGroupGoal(boolean lessThan, int caloriesGoal) {
        this.lessThan = lessThan;
        this.caloriesGoal = caloriesGoal;
    }

    @Override
    public String toString() {
        return "Have " + (lessThan ? "less than " : "more than ") + caloriesGoal + " cal/day";
    }
}
