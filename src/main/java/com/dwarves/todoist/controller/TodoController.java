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

    @PostMapping(path = "/add")
    public ResponseEntity<?> addTodo(@Valid @NonNull @RequestBody Todo todo) {

        if (todoService.addTodo(todo) == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping(path = "/edit")
    public ResponseEntity<?> editTodoById(@Valid @NonNull @RequestBody Todo todo) {

        if (!Utils.isIdValid(todo.getTodoId())) {
            return ResponseEntity.badRequest().build();
        }

        if (todoService.editTodoById(todo) == 0) {
            return ResponseEntity.notFound().build();
        }
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
