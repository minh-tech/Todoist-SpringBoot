package com.dwarves.todoist.dao;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    private final JdbcTemplate jdbcTemplate;

    public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int assignUsers(List<Integer> userId_list, int todoId)  throws DuplicateKeyException {
        final String sql = "INSERT INTO task_table (\"todoId\", \"userId\", complete) VALUES (?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, userId_list.get(i));
                preparedStatement.setInt(2, todoId);
                preparedStatement.setBoolean(3, false);
            }
            @Override
            public int getBatchSize() {
                return userId_list.size();
            }
        });
        return 1;
    }

    @Override
    public int doneTodo(int userId, int todoId) {
        final String sql = "UPDATE task_table SET complete = true WHERE \"todoId\" = ? AND \"userId\" = ?";
        return jdbcTemplate.update(sql, todoId, userId);
    }
}
