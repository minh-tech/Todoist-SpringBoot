package com.dwarves.todoist.model;

import com.dwarves.todoist.Utils.Constant;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Todo {

    private final int todoId;

    @NotNull
    private String content;

    @NotNull
    private String complete_date;

    public Todo(@JsonProperty(Constant.TODOID) int todoId,
                @JsonProperty(Constant.CONTENT) String content,
                @JsonProperty(Constant.COMPLETE_DATE) String complete_date) {
        this.todoId = todoId;
        this.content = content;
        this.complete_date = complete_date;
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
}
