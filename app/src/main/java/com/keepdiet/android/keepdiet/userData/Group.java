package com.keepdiet.android.keepdiet.userData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Liu Junlin on 2018/3/13.
 */

public class Group implements Serializable{
    private int maxUser;
    private int ID;
    private String name;
    private List<Integer> users;
    private String location;
    private String groupTarget;
    private int currentUserNum;

    public Group(int maxUser, int ID, String name, List<Integer> users, String location, String groupTarget) {
        this.maxUser = maxUser;
        this.ID = ID;
        this.name = name;
        this.users = users;
        this.location = location;
        this.groupTarget = groupTarget;

    }



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

    public String getGroupTarget() {
        return groupTarget;
    }

    public void setGroupTarget(String target) {
        groupTarget = groupTarget;
    }

    public int getCurrentUserNum() {
        return users == null ? 0 : users.size();
    }

}
