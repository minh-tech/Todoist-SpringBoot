package com.dwarves.todoist.service;

import com.dwarves.todoist.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskDao taskDao;

    @Autowired
    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public int assignUsers(List<Integer> userId_list, int todoId) {
        return taskDao.assignUsers(userId_list, todoId);
    }

    public int completeTodo(int userId, int todoId) {
        return taskDao.completeTodo(userId, todoId);
    }
}
