package com.dwarves.todoist.dao;

import org.springframework.dao.DuplicateKeyException;

import java.util.List;

public interface TaskDao {
    int assignUsers(List<Integer> user_list, int todo) throws DuplicateKeyException;
    int doneTodo(int todoId, int userId);
}
