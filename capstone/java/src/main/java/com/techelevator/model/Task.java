package com.techelevator.model;

import java.util.Date;

public class Task {
    private int id;
    private String taskTitle;
    private String taskDescription;
    private boolean taskIsCompleted;
    private Date taskDueDate;
    private Date taskCompletionDate;
    private int projectID;

    // Constructors

    public Task() {

    }

    public Task(int id, String taskTitle, String taskDescription, boolean taskIsCompleted, Date taskDueDate, Date taskCompletionDate, int projectID) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskIsCompleted = taskIsCompleted;
        this.taskDueDate = taskDueDate;
        this.taskCompletionDate = taskCompletionDate;
        this.projectID = projectID;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isTaskIsCompleted() {
        return taskIsCompleted;
    }

    public void setTaskIsCompleted(boolean taskIsCompleted) {
        this.taskIsCompleted = taskIsCompleted;
    }

    public Date getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(Date taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public Date getTaskCompletionDate() {
        return taskCompletionDate;
    }

    public void setTaskCompletionDate(Date taskCompletionDate) {
        this.taskCompletionDate = taskCompletionDate;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
}
