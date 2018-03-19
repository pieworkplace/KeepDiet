package com.keepdiet.android.keepdiet.userData;

/**
 * Created by Haoting on 17/03/2018.
 */

public class Target {
    public Target(String target, boolean status) {
        this.target = target;
        this.status = status;
    }

    private String target;
    private boolean status;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
