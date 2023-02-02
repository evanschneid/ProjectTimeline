package com.techelevator.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Task;

@Component
public class JdbcTaskDao implements TaskDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTaskDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Task task = mapRowToTask(results);
            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public Task getTaskById(int id) {
        String sql = "SELECT * FROM tasks WHERE task_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToTask(results);
        } else {
            return null;
        }
    }

    @Override
    public void insertTask(Task task) {

    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void deleteTask(int id) {

    }

    private Task mapRowToTask(SqlRowSet rs) {
        Task task = new Task();
        task.setId(rs.getInt("task_id"));
        /*task.setName(rs.getString("name"));
        task.setDescription(rs.getString("description"));
        task.setDeadline(rs.getDate("deadline"));
        task.setProjectId(rs.getInt("project_id"));*/
        return task;
    }
}

