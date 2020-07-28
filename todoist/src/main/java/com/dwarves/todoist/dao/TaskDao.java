package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.Todo;
import com.dwarves.todoist.model.User;

import java.util.List;

public interface TaskDao {
    int assignUsers(List<User> user_list, Todo todo);
    int completeTodo(int userId, Todo todo);
}
