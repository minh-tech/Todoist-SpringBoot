package com.dwarves.todoist.service;

import com.dwarves.todoist.dao.TodoDao;
import com.dwarves.todoist.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private final TodoDao todoDao;

    @Autowired
    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public List<Todo> getAllTodo() {
        return todoDao.getAllTodo();
    }

    public int addTodo(Todo todo) {
        return todoDao.addTodo(todo);
    }

    public int editTodoById(Todo todo) {
        return todoDao.editTodoById(todo);
    }

    public List<Todo> getTodoByDate(Date date) {
        return todoDao.getTodoByDate(date);
    }

    public List<Integer> getAllTodoIds() {
        return todoDao.getAllTodoIds();
    }
}
