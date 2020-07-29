package com.dwarves.todoist.service;

import com.dwarves.todoist.dao.TaskDao;
import com.dwarves.todoist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskDao taskDao;

    @Autowired
    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**
     * Assign multiple users into one todo
     * @param userId_list
     * @param todoId
     * @return
     * @throws DuplicateKeyException
     */
    public int assignUsers(List<Integer> userId_list, int todoId) throws DuplicateKeyException {
        return taskDao.assignUsers(userId_list, todoId);
    }

    /**
     * Complete a todo
     * @param userId
     * @param todoId
     * @return
     */
    public int doneTodo(int userId, int todoId) {
        return taskDao.doneTodo(userId, todoId);
    }

    /**
     * Get a list of assignments
     * @return
     */
    public List<Task> getAllAssignments() {
        return taskDao.getAllAssignments();
    }
}
