package com.dwarves.todoist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Todo {

    private int todoId;
    private String content;
    private Date complete_date;

    public Todo(@JsonProperty("todoId") int todoId,
                @JsonProperty("content") String content,
                @JsonProperty("complete_date") Date complete_date) {
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

    public Date getComplete_date() {
        return complete_date;
    }

    public void setComplete_date(Date complete_date) {
        this.complete_date = complete_date;
    }
}
