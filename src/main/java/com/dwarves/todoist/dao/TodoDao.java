package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.Todo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TodoDao {

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
    int editTodoById(Map<String, String> todo);

    /**
     * Get todos by parameters
     * @param allParams
     * @return
     */
    List<Todo> getTodoByParams(Map<String, String> allParams);

    /**
     * Get a list of todoIds
     * @return
     */
    List<Integer> getAllTodoIds();
}
