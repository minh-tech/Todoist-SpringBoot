package com.dwarves.todoist.service;

import com.dwarves.todoist.dao.UserDao;
import com.dwarves.todoist.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public List<Integer> getAllUserIds() {
        return userDao.getAllUserIds();
    }
}
