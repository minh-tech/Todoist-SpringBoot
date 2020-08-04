package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.Task;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

public interface TaskDao {

    /**
     * Assign multiple users into one todo
     * @param assignee_Ids
     * @param todo
     * @return
     * @throws DuplicateKeyException
     */
    int assignUsers(List<Integer> assignee_Ids, int todo) throws DuplicateKeyException;

    /**
     * Complete a todo
     * @param task
     * @return
     */
    int updateAssignment(Task task);

    /**
     * Get a list of assignments
     * @return
     */
    List<Task> getAllAssignments();
}
