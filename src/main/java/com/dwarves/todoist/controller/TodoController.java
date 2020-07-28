package com.dwarves.todoist.controller;

import com.dwarves.todoist.Utils.Constant;
import com.dwarves.todoist.Utils.Utils;
import com.dwarves.todoist.model.Todo;
import com.dwarves.todoist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

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
    public ResponseEntity<?> insertTodo(@Valid @NonNull @RequestBody Todo todo) {
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
    public ResponseEntity<?> getTodoByDate(@PathVariable("date")String dateStr) {
        Date date = Utils.convertStringToDate(dateStr, Constant.PATTERN);

        if (date == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(todoService.getTodoByDate(date));
    }
}
