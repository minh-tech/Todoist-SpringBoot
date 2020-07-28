package com.dwarves.todoist.controller;

import com.dwarves.todoist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("api/task")
@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @SuppressWarnings("unchecked")
    @PostMapping
    public ResponseEntity<?> assignUsers(@RequestBody @NonNull Map<String, Object> json) {
        try {
            taskService.assignUsers((List<Integer>) json.get("userId_list"),
                    (int) json.get("todoId"));
        } catch(ClassCastException e) {
            return ResponseEntity.badRequest().build();
            }
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/done")
    public ResponseEntity<?> completeTodo(@RequestBody @NonNull Map<String, Object> json) {
        taskService.completeTodo((int) json.get("userId"), (int) json.get("todoId"));
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
