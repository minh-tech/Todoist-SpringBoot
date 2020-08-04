package com.dwarves.todoist.dao;

import com.dwarves.todoist.Utils.Constant;
import com.dwarves.todoist.Utils.TodoStatus;
import com.dwarves.todoist.Utils.Utils;
import com.dwarves.todoist.model.Todo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
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
    public List<Todo> getAllTodo() {
        final String sql = "SELECT * FROM todo_table";
        return jdbcTemplate.query(sql, ((resultSet, i) -> new Todo(
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
                TodoStatus.OPEN.getStatusPhrase()
        );
    }

    @Override
    public int editTodoById(Map<String, Object> todo) {

        StringBuilder sqlBuilder = new StringBuilder("UPDATE todo_table SET");
        List<Object> obj = new ArrayList<>();
        List<Integer> types = new ArrayList<>();

        if (Utils.isKeyValid(todo, Constant.CONTENT)) {
            sqlBuilder.append(" content = ?,");
            obj.add(todo.get(Constant.CONTENT));
            types.add(Types.VARCHAR);
        }

        if (Utils.isKeyValid(todo, Constant.COMPLETE_DATE)) {
            sqlBuilder.append(" complete_date = ?,");
            Date date = Utils.convertStringToDate(
                    todo.get(Constant.COMPLETE_DATE).toString(),
                    Constant.PATTERN);
            obj.add(date);
            types.add(Types.DATE);
        }

        if (Utils.isKeyValid(todo, Constant.STATUS)) {
            sqlBuilder.append(" status = ?,");
            obj.add(todo.get(Constant.STATUS));
            types.add(Types.VARCHAR);
        }

        obj.add(todo.get(Constant.TODOID));
        types.add(Types.INTEGER);

        int[] int_array = types.stream().mapToInt(i->i).toArray();

        sqlBuilder.deleteCharAt(sqlBuilder.length()-1);
        sqlBuilder.append(" WHERE \"todoId\" = ?");

        final String sql = sqlBuilder.toString();

        return jdbcTemplate.update(
                sql,
                obj.toArray(),
                int_array
        );
    }

    @Override
    public List<Todo> getTodoByDate(Date date) {
        final String sql = "SELECT * FROM todo_table WHERE complete_date = ?";

        return jdbcTemplate.query(sql, new Object[]{date}, ((resultSet, i) -> new Todo(
                resultSet.getInt(Constant.TODOID),
                resultSet.getString(Constant.CONTENT),
                Utils.convertDateToString(resultSet.getDate(Constant.COMPLETE_DATE), Constant.PATTERN),
                resultSet.getInt(Constant.ASSIGNER_ID),
                resultSet.getString(Constant.STATUS)
        )));
    }

    @Override
    public List<Integer> getAllTodoIds() {
        final String sql = "SELECT \"todoId\" FROM todo_table ORDER BY \"todoId\" ASC";
        return jdbcTemplate.query(sql, ((resultSet, i) ->
                resultSet.getInt(Constant.TODOID)
        ));
    }
}
