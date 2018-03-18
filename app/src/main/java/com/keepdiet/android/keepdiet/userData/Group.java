package com.keepdiet.android.keepdiet.userData;

import java.util.List;

/**
 * Created by Liu Junlin on 2018/3/13.
 */

public class Group {
    private int maxUser;
    private int ID;
    private String name;
    private List<Integer> users;
    private String location;
    private String Target;

    public int getMaxUser() {
        return maxUser;
    }

    public void setMaxUser(int maxUser) {
        this.maxUser = maxUser;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTarget() {
        return Target;
    }

    public void setTarget(String target) {
        Target = target;
    }
}
