package com.dwarves.todoist.controller;

import com.dwarves.todoist.model.Todo;
import com.dwarves.todoist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAllTodo() {
        return ResponseEntity.ok(todoService.getAllTodo());
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> insertTodo(@NonNull @RequestBody Todo todo) {
        System.out.println(todo.getComplete_date());
        todoService.insertTodo(todo);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<?> updateTodoById(@NonNull @RequestBody Todo todo) {
        todoService.updateTodoById(todo);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{date}")
    public ResponseEntity<?> getTodoByDate(@PathVariable("date")String str_date) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(str_date);
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(todoService.getTodoByDate(date));
    }
}
