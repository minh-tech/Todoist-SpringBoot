package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.Todo;
import com.dwarves.todoist.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        final String sql = "SELECT * FROM user_table";
        return jdbcTemplate.query(sql, ((resultSet, i) -> new User(
                resultSet.getInt("userId"),
                resultSet.getString("username")
        )));
    }

    @Override
    public int addUser(User user) {
        final String sql = "INSERT INTO user_table (username) VALUES (?)";
        return jdbcTemplate.update(sql, user.getUsername());
    }
}
