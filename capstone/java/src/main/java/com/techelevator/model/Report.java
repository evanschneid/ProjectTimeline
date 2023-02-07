package com.techelevator.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Report {
    private int id;
    private int userId;
    private LocalDateTime clockIn;
    private LocalDateTime clockOut;
    private int projectID;
    private int totalTime;
    private String addedComment;

    // Constructors

    public Report() {
    }

    public Report(int id, int userId, LocalDateTime clockIn, LocalDateTime clockOut, int projectID, int totalTime, String addedComment) {
        this.id = id;
        this.userId = userId;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.projectID = projectID;
        this.totalTime = totalTime;
        this.addedComment = addedComment;
    }

    // Getters and Setters

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

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getAddedComment() {
        return addedComment;
    }

    public void setAddedComment(String addedComment) {
        this.addedComment = addedComment;
    }
}
