package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.Task;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

public interface TaskDao {

    /**
     * Assign multiple users into one todo
     * @param userId_list
     * @param todo
     * @return
     * @throws DuplicateKeyException
     */
    int assignUsers(List<Integer> userId_list, int todo) throws DuplicateKeyException;

    /**
     * Complete a todo
     * @param todoId
     * @param userId
     * @return
     */
    int doneTodo(int todoId, int userId);

    /**
     * Get a list of assignments
     * @return
     */
    List<Task> getAllAssignments();
}
