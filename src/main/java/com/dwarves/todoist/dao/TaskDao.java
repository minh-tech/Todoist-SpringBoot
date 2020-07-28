package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.Todo;
import com.dwarves.todoist.model.User;

import java.util.List;

public interface TaskDao {
    int assignUsers(List<Integer> user_list, int todo);
    int completeTodo(int todoId, int userId);
}
