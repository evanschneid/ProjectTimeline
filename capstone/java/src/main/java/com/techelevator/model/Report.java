package com.techelevator.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Report {
    private int id;
    private int userId;
    private LocalDateTime clockIn;
    private LocalDateTime clockOut;
    private int projectId;
    private long totalTime;
    private String addedComment;

    private String projectTitle;

    // Constructors

    public Report() {
    }

    public Report(int id, int userId, LocalDateTime clockIn, LocalDateTime clockOut, int projectId, long totalTime, String addedComment, String projectTitle) {
        this.id = id;
        this.userId = userId;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.projectId = projectId;
        this.totalTime = totalTime;
        this.addedComment = addedComment;
        this.projectTitle = projectTitle;
    }

    // Getters and Setters


    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getClockIn() {
        return clockIn;
    }

    public void setClockIn(LocalDateTime clockIn) {
        this.clockIn = clockIn;
    }

    public LocalDateTime getClockOut() {
        return clockOut;
    }

    public void setClockOut(LocalDateTime clockOut) {
        this.clockOut = clockOut;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectID(int projectId) {
        this.projectId = projectId;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public String getAddedComment() {
        return addedComment;
    }

    public void setAddedComment(String addedComment) {
        this.addedComment = addedComment;
    }
}
