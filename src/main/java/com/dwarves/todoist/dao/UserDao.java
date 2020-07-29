package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.User;

import java.util.List;

public interface UserDao {

    /**
     * Get a list of users
     * @return
     */
    List<User> getAllUsers();

    /**
     * Add a new user
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * Get a list of user Ids
     * @return
     */
    List<Integer> getAllUserIds();

}
