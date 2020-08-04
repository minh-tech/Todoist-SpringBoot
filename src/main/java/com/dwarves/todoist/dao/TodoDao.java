package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.Todo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TodoDao {

    /**
     * Get a list of todos
     * @return
     */
    List<Todo> getAllTodo();

    /**
     * Create a new todo
     * @param todo
     * @return
     */
    int addTodo(Todo todo);

    /**
     * Edit a todo by ID
     * @param todo
     * @return
     */
    int editTodoById(Map<String, Object> todo);

    /**
     * Group todos by date
     * @param date
     * @return
     */
    List<Todo> getTodoByDate(Date date);

    /**
     * Get a list of todoIds
     * @return
     */
    List<Integer> getAllTodoIds();
}
