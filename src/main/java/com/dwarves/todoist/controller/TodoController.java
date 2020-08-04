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
import java.util.List;
import java.util.Map;

@RequestMapping("api/todo")
@RestController
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<?> getTodoList(@RequestParam Map<String, String> allParams) {

        if (allParams.isEmpty()) {
            return ResponseEntity.ok(todoService.getAllTodo());
        }

        List<Todo> result = todoService.getTodoByParams(allParams);
        if (result == null) {
            return ResponseEntity.badRequest().body(Constant.PARAMS_INVALID);
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> addTodo(@Valid @NonNull @RequestBody Todo todo) {

        todoService.addTodo(todo);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> editTodoById(@NonNull @RequestBody Map<String, Object> todo) {
        int todoId = (int) todo.get("todoId");
        // Check a todoID is valid
        if (!Utils.isIdValid(todoId)) {
            return ResponseEntity.badRequest().body(Constant.TODO_INVALID);
        }

        // Check a todoID exist in database
        List<Integer> todoIds = todoService.getAllTodoIds();
        if (!Utils.isIdExisted(todoIds, todoId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constant.TODO_NOT_FOUND);
        }

        todoService.editTodoById(todo);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
