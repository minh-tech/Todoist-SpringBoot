package com.dwarves.todoist.model;

import com.dwarves.todoist.Utils.Constant;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Todo {

    private final int todoId;

    @NotNull
    private String content;

    @NotNull
    private String complete_date;

    @NotNull
    private int assignerId;

    private String status;

    @JsonCreator
    public Todo(@JsonProperty(Constant.TODOID) int todoId,
                @JsonProperty(Constant.CONTENT) String content,
                @JsonProperty(Constant.COMPLETE_DATE) String complete_date,
                @JsonProperty(Constant.ASSIGNER_ID) int assignerId,
                @JsonProperty(Constant.STATUS) String status) {
        this.todoId = todoId;
        this.content = content;
        this.complete_date = complete_date;
        this.assignerId = assignerId;
        this.status = status;
    }

    public int getTodoId() {
        return todoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComplete_date() {
        return complete_date;
    }

    public void setComplete_date(String complete_date) {
        this.complete_date = complete_date;
    }

    public int getAssignerId() {
        return assignerId;
    }

    public void setAssignerId(int assignerId) {
        this.assignerId = assignerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
