package com.dwarves.todoist.controller;

import com.dwarves.todoist.Utils.Constant;
import com.dwarves.todoist.Utils.Utils;
import com.dwarves.todoist.service.TaskService;
import com.dwarves.todoist.service.TodoService;
import com.dwarves.todoist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("api/task")
@RestController
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;
    private final TodoService todoService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService, TodoService todoService) {
        this.taskService = taskService;
        this.userService = userService;
        this.todoService = todoService;
    }

    @SuppressWarnings("unchecked")
    @PostMapping
    public ResponseEntity<?> assignUsers(@NonNull @RequestBody Map<String, Object> json) {
        List<Integer> userIdList;
        int todoId = (int) json.get(Constant.TODOID);
        try {
            userIdList = (List<Integer>) json.get(Constant.USERID_LIST);

            if (!userIdList.stream().allMatch(Utils::isIdValid)) {
                return ResponseEntity.badRequest().build();
            }

            List<Integer> todoIds = todoService.getAllTodoIds();
            if (!Utils.isIdExisted(todoIds, todoId)) {
                return ResponseEntity.badRequest().build();
            }

            List<Integer> userIds = userService.getAllUserIds();
            if (!userIdList.stream().allMatch(id -> Utils.isIdExisted(userIds, id))) {
                return ResponseEntity.badRequest().build();
            }
//            for (int id : userIdList) {
//                if (!Utils.isIdExisted(userIds, id)) {
//                    return ResponseEntity.badRequest().build();
//                }
//            }

            taskService.assignUsers(userIdList, todoId);
        } catch(ClassCastException | DuplicateKeyException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/done")
    public ResponseEntity<?> doneTodo(@NonNull @RequestBody Map<String, Object> json) {
        int userId = (int) json.get(Constant.USERID);
        int todoId = (int) json.get(Constant.TODOID);

        List<Integer> todoIds = todoService.getAllTodoIds();
        if (!Utils.isIdExisted(todoIds, todoId)) {
            return ResponseEntity.badRequest().build();
        }

        List<Integer> userIds = userService.getAllUserIds();
        if (!Utils.isIdExisted(userIds, userId)) {
            return ResponseEntity.badRequest().build();
        }

        if (taskService.doneTodo(userId, todoId) == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
