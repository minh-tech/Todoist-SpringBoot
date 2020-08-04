package com.dwarves.todoist.dao;

import com.dwarves.todoist.Utils.Constant;
import com.dwarves.todoist.model.Task;
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
    public int assignUsers(List<Integer> assignee_Ids, int todoId)  throws DuplicateKeyException {
        final String sql = "INSERT INTO task_table (\"todoId\", \"userId\", complete) VALUES (?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, todoId);
                preparedStatement.setInt(2, assignee_Ids.get(i));
                preparedStatement.setBoolean(3, false);
            }
            @Override
            public int getBatchSize() {
                return assignee_Ids.size();
            }
        });
        return 1;
    }

    @Override
    public int doneTodo(int userId, int todoId) {
        final String sql = "UPDATE task_table SET complete = true WHERE \"todoId\" = ? AND \"userId\" = ?";
        return jdbcTemplate.update(sql, todoId, userId);
    }

    @Override
    public List<Task> getAllAssignments() {
        final String sql = "SELECT * FROM task_table";
        return jdbcTemplate.query(sql, ((resultSet, i) -> new Task(
                resultSet.getInt(Constant.TODOID),
                resultSet.getInt(Constant.ASSIGNEE_ID),
                resultSet.getString(Constant.COMMENT),
                resultSet.getBoolean(Constant.IS_COMPLETE)
        )));
    }
}
