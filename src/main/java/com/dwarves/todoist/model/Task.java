package com.dwarves.todoist.model;

import com.dwarves.todoist.Utils.Constant;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Task {

    @NotNull
    @Min(value = 1)
    private int todoId;

    @NotNull
    @Min(value = 1)
    private int assigneeId;

    private String comment;

    public Task(@JsonProperty(Constant.TODOID) int todoId,
                @JsonProperty(Constant.ASSIGNEE_ID) int assigneeId,
                @JsonProperty(Constant.COMMENT) String comment) {
        this.todoId = todoId;
        this.assigneeId = assigneeId;
        this.comment = comment;
    }

    public Task(int assigneeId, String comment) {
        this.assigneeId = assigneeId;
        this.comment = comment;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
