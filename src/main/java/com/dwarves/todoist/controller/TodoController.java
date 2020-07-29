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

        todoService.addTodo(todo);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping(path = "/edit")
    public ResponseEntity<?> editTodoById(@Valid @NonNull @RequestBody Todo todo) {

        // Check a todoID is valid
        if (!Utils.isIdValid(todo.getTodoId())) {
            return ResponseEntity.badRequest().body(Constant.TODO_INVALID);
        }

        // Check a todoID exist in database
        List<Integer> todoIds = todoService.getAllTodoIds();
        if (!Utils.isIdExisted(todoIds, todo.getTodoId())) {
            return ResponseEntity.badRequest().body(Constant.TODO_NOT_EXIST);
        }

        todoService.editTodoById(todo);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{date}")
    public ResponseEntity<?> getTodoByDate(@PathVariable("date")String dateStr) {
        Date date = Utils.convertStringToDate(dateStr, Constant.PATTERN);

        // Check Date is valid
        if (date == null) {
            return ResponseEntity.badRequest().body(Constant.DATE_INVALID);
        }
        return ResponseEntity.ok(todoService.getTodoByDate(date));
    }
}
