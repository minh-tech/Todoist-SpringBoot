package com.dwarves.todoist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    int userId;
    String username;

    public User(@JsonProperty("username") String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
