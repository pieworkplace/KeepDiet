package com.keepdiet.android.keepdiet.userData;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Liu Junlin on 2018/3/12.
 */

public class Diary implements Serializable {
    //identity
    private int ID;
    private int userID;
    private LocalDate date;
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
    //exercise
    private List<Exercise> exerciseList;

    public int getCaloryGoal() {
        return caloryGoal;
    }

    public int getCaloryConsumed() {
        return caloryConsumed;
    }

    public int getCaloryBurned() {
        return caloryBurned;
    }

    public int getCaloryRemaining() {
        return caloryRemaining;
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

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void addBreakfastList(Food food) {
        breakfastList.add(food);
        caloryConsumed += food.getTotalCalory();
        caloryRemaining -= food.getTotalCalory();
    }

    public void addLunchList(Food food) {
        lunchList.add(food);
        caloryConsumed += food.getTotalCalory();
        caloryRemaining -= food.getTotalCalory();
    }

    public void addDinnerList(Food food) {
        dinnerList.add(food);
        caloryConsumed += food.getTotalCalory();
        caloryRemaining -= food.getTotalCalory();
    }

    public void addSnackList(Food food) {
        snackList.add(food);
        caloryConsumed += food.getTotalCalory();
        caloryRemaining -= food.getTotalCalory();
    }

    public void addExerciseList(Exercise exercise){
        exerciseList.add(exercise);
        caloryBurned += exercise.getCaloryBurned();
        caloryRemaining += exercise.getCaloryBurned();
    }

    public int getBreakfastTotalCalory() {
        int sum = 0;
        for (Food food : breakfastList) {
            sum += food.getTotalCalory();
        }
        return sum;
    }

    public int getLunchTotalCalory() {
        int sum = 0;
        for (Food food : lunchList) {
            sum += food.getTotalCalory();
        }
        return sum;
    }

    public int getDinnerTotalCalory() {
        int sum = 0;
        for (Food food : dinnerList) {
            sum += food.getTotalCalory();
        }
        return sum;
    }

    public int getSnackTotalCalory() {
        int sum = 0;
        for (Food food : snackList) {
            sum += food.getTotalCalory();
        }
        return sum;
    }

    public int getExerciseTotalCalory(){
        int sum = 0;
        for (Exercise exercise : exerciseList){
            sum += exercise.getCaloryBurned();
        }
        return sum;
    }

    public void editBreakfastList(int position, Food food){
        if (position < breakfastList.size() && position >= 0){
            caloryConsumed -= breakfastList.get(position).getTotalCalory();
            breakfastList.set(position, food);
            caloryConsumed += breakfastList.get(position).getTotalCalory();
            caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        }
    }

    public void editLunchList(int position, Food food){
        if (position < lunchList.size() && position >= 0){
            caloryConsumed -= lunchList.get(position).getTotalCalory();
            lunchList.set(position, food);
            caloryConsumed += lunchList.get(position).getTotalCalory();
            caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        }
    }

    public void editDinnerList(int position, Food food){
        if (position < dinnerList.size() && position >= 0){
            caloryConsumed -= dinnerList.get(position).getTotalCalory();
            dinnerList.set(position, food);
            caloryConsumed += dinnerList.get(position).getTotalCalory();
            caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        }
    }

    public void editSnackList(int position, Food food){
        if (position < snackList.size() && position >= 0){
            caloryConsumed -= snackList.get(position).getTotalCalory();
            snackList.set(position, food);
            caloryConsumed += snackList.get(position).getTotalCalory();
            caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        }
    }

    public void editExerciseList(int position, Exercise exercise){
        if (position < exerciseList.size() && position >= 0){
            caloryBurned -= exerciseList.get(position).getCaloryBurned();
            exerciseList.set(position, exercise);
            caloryBurned += exerciseList.get(position).getCaloryBurned();
            caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        }
    }

    public void removeBreakfastList(int position){
        if (position < breakfastList.size() && position >= 0){
            caloryConsumed -= breakfastList.get(position).getTotalCalory();
            breakfastList.remove(position);
            caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        }
    }

    public void removeLunchList(int position){
        if (position < lunchList.size() && position >= 0){
            caloryConsumed -= lunchList.get(position).getTotalCalory();
            lunchList.remove(position);
            caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        }
    }

    public void removeDinnerList(int position){
        if (position < dinnerList.size() && position >= 0){
            caloryConsumed -= dinnerList.get(position).getTotalCalory();
            dinnerList.remove(position);
            caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        }
    }

    public void removeSnackList(int position){
        if (position < snackList.size() && position >= 0){
            caloryConsumed -= snackList.get(position).getTotalCalory();
            snackList.remove(position);
            caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        }
    }

    public void removeExerciseList(int position){
        if (position < exerciseList.size() && position >= 0){
            caloryBurned -= exerciseList.get(position).getCaloryBurned();
            exerciseList.remove(position);
            caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Diary() {
        //TODO change fake data
        date = (new Date(2018 - 1900,8 - 1,20)).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        userID = 0;
        ID = Integer.parseInt(date.toString().replace("-", ""));

        caloryGoal = 2000;
        caloryBurned = 0;
        caloryConsumed = 0;
        caloryRemaining = caloryGoal - caloryConsumed + caloryBurned;

        breakfastList = new ArrayList<Food>();
        lunchList = new ArrayList<Food>();
        dinnerList = new ArrayList<Food>();
        snackList = new ArrayList<Food>();

        exerciseList = new ArrayList<Exercise>();

        addDinnerList(new Food("Fried Chicken", 200, 1, "pound"));
        addDinnerList(new Food("Fried Chicken", 200, 1, "pound"));
        addBreakfastList(new Food("Fried Chicken", 200, 1, "pound"));
        addExerciseList(new Exercise("running", 200, 1, "lalala"));
        addExerciseList(new Exercise("running", 200, 1, "lalala"));
    }


}
