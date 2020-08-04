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
     * @param assignee_Ids
     * @param todoId
     * @return
     * @throws DuplicateKeyException
     */
    public int assignUsers(List<Integer> assignee_Ids, int todoId) throws DuplicateKeyException {
        return taskDao.assignUsers(assignee_Ids, todoId);
    }

    /**
     * Complete a todo
     * @param task
     * @return
     */
    public int updateAssignment(Task task) {
        return taskDao.updateAssignment(task);
    }

    /**
     * Get a list of assignments
     * @return
     */
    public List<Task> getAllAssignments() {
        return taskDao.getAllAssignments();
    }
}
