package com.acrs.userapp.ui.buddy.buddy_list;

public class BuddyListModel {

    String name;
    String phone;
    int active;

    public BuddyListModel(String name, String phone, int active) {
        this.name = name;
        this.phone = phone;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
