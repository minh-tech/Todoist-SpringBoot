package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.Todo;

import java.util.Date;
import java.util.List;

public interface TodoDao {

    List<Todo> getAllTodo();
    int insertTodo(Todo todo);
    int updateTodoById(Todo todo);
    List<Todo> getTodoByDate(Date date);
}
