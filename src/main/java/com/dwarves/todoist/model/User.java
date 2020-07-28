package com.dwarves.todoist.model;

import com.dwarves.todoist.Utils.Constant;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class User {

    private final int userId;

    @NotNull
    private String username;

    public User(@JsonProperty(Constant.USERID) int userId,
                @JsonProperty(Constant.USERNAME) String username) {
        this.userId = userId;
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
