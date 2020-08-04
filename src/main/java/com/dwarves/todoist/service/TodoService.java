package com.dwarves.todoist.service;

import com.dwarves.todoist.Utils.Constant;
import com.dwarves.todoist.Utils.Utils;
import com.dwarves.todoist.dao.TodoDao;
import com.dwarves.todoist.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TodoService {

    private final TodoDao todoDao;

    @Autowired
    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public int addTodo(Todo todo) {
        return todoDao.addTodo(todo);
    }

    public int editTodoById(Map<String, String> todo) {

        return todoDao.editTodoById(todo);
    }

    public List<Todo> getTodoByParams(Map<String, String> allParams) {

        return todoDao.getTodoByParams(allParams);
    }

    public List<Integer> getAllTodoIds() {
        return todoDao.getAllTodoIds();
    }
}
