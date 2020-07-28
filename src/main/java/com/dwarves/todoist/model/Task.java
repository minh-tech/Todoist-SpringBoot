package com.dwarves.todoist.model;

import com.dwarves.todoist.Utils.Constant;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Task {

    @NotNull
    private int todoId;

    @NotNull
    private int userId;

    @NotNull
    private boolean complete;

    public Task(@JsonProperty(Constant.TODOID) int todoId,
                @JsonProperty(Constant.USERID)int userId,
                @JsonProperty(Constant.COMPLETE) boolean complete) {
        this.todoId = todoId;
        this.userId = userId;
        this.complete = complete;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
