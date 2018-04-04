package com.keepdiet.android.keepdiet.userData;

import com.keepdiet.android.keepdiet.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu Junlin on 2018/3/13.
 */

public class Group implements Serializable{
    private int ID;
    private String name;
    private List<Integer> users;
    private GroupGoal groupGoal;
    private int chip;

    public Group() {
        this.ID = 12345;
        this.name = "KeepDiet";
        this.users = new ArrayList<Integer>(){{add(5); add(10);}};
        this.groupGoal = new CaloriesGroupGoal(true, 2000);
        chip = 50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupGoal getGroupGoal() {
        return groupGoal;
    }

    public List<List<String>> groupToList(){
        List result =  new ArrayList<>();
        result.add(new ArrayList<String>(){{add(("Group Name")); add(name);}});
        result.add(new ArrayList<String>(){{add(("Group Goal")); add(groupGoal.toString());}});
        result.add(new ArrayList<String>(){{add(("Daily Chip")); add(Integer.toString(chip));}});
        return result;
    }

}
