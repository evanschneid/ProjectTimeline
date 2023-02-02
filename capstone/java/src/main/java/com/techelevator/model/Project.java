package com.techelevator.model;

import java.util.Date;

public class Project {
    private int id;
    private String projectTitle;
    private String projectDescription;
    private String projectImg;
    private boolean projectIsCompleted;
    private Date projectDueDate;
    private Date projectCompletionDate;
    private int userId;
    private boolean isShared;

    // Constructors

    public Project() {

    }

    public Project(int id, String projectTitle, String projectDescription, String projectImg, boolean projectIsCompleted, Date projectDueDate, Date projectCompletionDate, int userId, boolean isShared) {
        this.id = id;
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.projectImg = projectImg;
        this.projectIsCompleted = projectIsCompleted;
        this.projectDueDate = projectDueDate;
        this.projectCompletionDate = projectCompletionDate;
        this.userId = userId;
        this.isShared = isShared;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(String projectImg) {
        this.projectImg = projectImg;
    }

    public boolean isProjectIsCompleted() {
        return projectIsCompleted;
    }

    public void setProjectIsCompleted(boolean projectIsCompleted) {
        this.projectIsCompleted = projectIsCompleted;
    }

    public Date getProjectDueDate() {
        return projectDueDate;
    }

    public void setProjectDueDate(Date projectDueDate) {
        this.projectDueDate = projectDueDate;
    }

    public Date getProjectCompletionDate() {
        return projectCompletionDate;
    }

    public void setProjectCompletionDate(Date projectCompletionDate) {
        this.projectCompletionDate = projectCompletionDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }
}
