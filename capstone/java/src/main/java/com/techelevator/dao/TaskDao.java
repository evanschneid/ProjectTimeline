package com.techelevator.dao;

import com.techelevator.model.Task;

import java.util.List;

public interface TaskDao {
    void insertTask(Task task);
    Task getTaskById(int id);
    List<Task> getAllTasks();
    void updateTask(Task task);
    void deleteTask(int id);
}