package com.dwarves.todoist.dao;

import com.dwarves.todoist.Utils.Constant;
import com.dwarves.todoist.Utils.Utils;
import com.dwarves.todoist.model.Todo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class TodoDaoImpl implements TodoDao{

    private final JdbcTemplate jdbcTemplate;

    public TodoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Todo> getTodoByParams(Map<String, String> allParams) {

        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM todo_table");
        List<Object> obj = new ArrayList<>();

        if (!allParams.isEmpty()) {
            sqlBuilder.append(" WHERE");

            int isCraft = Utils.craftSqlQuery(obj, allParams, Constant.TODOID, sqlBuilder, " \"todoId\" = ?");
            isCraft |= Utils.craftSqlQuery(obj, allParams, Constant.COMPLETE_DATE, sqlBuilder, " complete_date = ?", " AND", " WHERE");
            isCraft |= Utils.craftSqlQuery(obj, allParams, Constant.ASSIGNER_ID, sqlBuilder, " \"assignerId\" = ?", " AND", " WHERE");
            isCraft |= Utils.craftSqlQuery(obj, allParams, Constant.STATUS, sqlBuilder, " status = ?", " AND", " WHERE");

            if (isCraft == 0) {
                return null;
            }
        }

        final String sql = sqlBuilder.toString();

        return jdbcTemplate.query(sql, obj.toArray(), ((resultSet, i) -> new Todo(
                resultSet.getInt(Constant.TODOID),
                resultSet.getString(Constant.CONTENT),
                Utils.convertDateToString(resultSet.getDate(Constant.COMPLETE_DATE), Constant.PATTERN),
                resultSet.getInt(Constant.ASSIGNER_ID),
                resultSet.getString(Constant.STATUS)
        )));
    }

    @Override
    public int addTodo(Todo todo) {
        final String sql = "INSERT INTO todo_table (content, complete_date, \"assignerId\", status) VALUES (?, ?, ?, ?)";
        Date date = Utils.convertStringToDate(todo.getComplete_date(), Constant.PATTERN);
        return jdbcTemplate.update(
                sql,
                todo.getContent(),
                date,
                todo.getAssignerId(),
                todo.getStatus()
        );
    }

    @Override
    public int editTodoById(Map<String, String> todo) {

        StringBuilder sqlBuilder = new StringBuilder("UPDATE todo_table SET ");
        List<Object> obj = new ArrayList<>();

        int isCraft = Utils.craftSqlQuery(obj, todo, Constant.CONTENT, sqlBuilder, "content = ?");
        isCraft |= Utils.craftSqlQuery(obj, todo, Constant.COMPLETE_DATE, sqlBuilder, "complete_date = ?", ", ", "SET ");
        isCraft |= Utils.craftSqlQuery(obj, todo, Constant.STATUS, sqlBuilder, "status = ?", ", ", "SET ");

        if (isCraft == 0) {
            return 0;
        }
        Utils.craftSqlQuery(obj, todo, Constant.TODOID, sqlBuilder, " WHERE \"todoId\" = ?");

        final String sql = sqlBuilder.toString();
        return jdbcTemplate.update(
                sql,
                obj.toArray()
        );
    }

    @Override
    public List<Integer> getAllTodoIds() {
        final String sql = "SELECT \"todoId\" FROM todo_table ORDER BY \"todoId\" ASC";
        return jdbcTemplate.query(sql, ((resultSet, i) ->
                resultSet.getInt(Constant.TODOID)
        ));
    }
}
