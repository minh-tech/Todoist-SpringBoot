package com.dwarves.todoist.controller;

import com.dwarves.todoist.model.Todo;
import com.dwarves.todoist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("api/todo")
@RestController
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodo() {
        return todoService.getAllTodo();
    }

    @PostMapping
    public void insertTodo(@NonNull @RequestBody Todo todo) {
        todoService.insertTodo(todo);
    }

    @PostMapping(path = "/update")
    public void updateTodoById(@NonNull @RequestBody Todo todo) {
        todoService.updateTodoById(todo);
    }

    @GetMapping(path = "/{date}")
    public List<Todo> getTodoByDate(@PathVariable("date")String str_date) {
        System.out.println(str_date);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(str_date);
        } catch (ParseException e) {
            return null;
        }
        return todoService.getTodoByDate(date);
    }
}
