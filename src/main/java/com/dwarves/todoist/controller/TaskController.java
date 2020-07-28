package com.dwarves.todoist.controller;

import com.dwarves.todoist.model.Todo;
import com.dwarves.todoist.model.User;
import com.dwarves.todoist.service.TaskService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void assignUsers(@RequestBody @NonNull Map<String, Object> json) {
        taskService.assignUsers((List<Integer>) json.get("userId_list"), (int) json.get("todoId"));
    }

    @PostMapping(path = "/done")
    public void completeTodo(@RequestBody @NonNull Map<String, Object> json) {
        taskService.completeTodo((int) json.get("userId"), (int) json.get("todoId"));
    }
}
