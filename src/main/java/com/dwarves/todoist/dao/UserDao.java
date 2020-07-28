package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    int addUser(User user);

}
