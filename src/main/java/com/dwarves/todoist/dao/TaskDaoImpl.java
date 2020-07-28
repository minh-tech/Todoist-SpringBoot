package com.dwarves.todoist.dao;

import com.dwarves.todoist.model.Todo;
import com.dwarves.todoist.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    private final JdbcTemplate jdbcTemplate;

    public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int assignUsers(List<Integer> userId_list, int todoId) {
        final String sql = "INSERT INTO task_table (\"todoId\", \"userId\", complete) VALUES (?, ?, ?)";
        for (int userId : userId_list) {
            jdbcTemplate.update(sql, todoId, userId, false);
        }
        return 1;
    }

    @Override
    public int completeTodo(int userId, int todoId) {
        final String sql = "UPDATE task_table SET complete = true WHERE \"todoId\" = ? AND \"userId\" = ?";
        return jdbcTemplate.update(sql, todoId, userId);
    }
}
