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
        String sql = "SELECT * FROM task";
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

    public List<Task> getTaskByProjectId(int projectId) {
        String sql = "SELECT * FROM task WHERE projectid = ?";
        List<Task> taskList = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
        while (results.next()) {
            Task task = mapRowToTask(results);
            taskList.add(task);
        }
        return taskList;
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

    private Task mapRowToTask(SqlRowSet result) {
        Task task = new Task();
        task.setId(result.getInt("taskid"));
        task.setTaskTitle(result.getString("tasktitle"));
        task.setTaskDescription(result.getString("taskdescription"));
        task.setTaskIsCompleted(result.getBoolean("taskiscompleted"));
        task.setTaskDueDate(result.getDate("taskduedate"));
        task.setTaskCompletionDate(result.getDate("taskcompletiondate"));
        task.setProjectID(result.getInt("projectid"));
        return task;
    }
}

