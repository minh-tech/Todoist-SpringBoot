package com.dwarves.todoist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    int todoId;
    int userId;
    boolean complete;

    public Task(@JsonProperty("todoId") int todoId,
                @JsonProperty("userId")int userId,
                @JsonProperty("complete") boolean complete) {
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
