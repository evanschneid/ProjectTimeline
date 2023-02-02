package com.techelevator.model;

import java.util.Date;

public class Report {
    private int id;
    private int userId;
    private Date clockIn;
    private Date clockOut;
    private int projectID;
    private int totalTime;
    private String addedComment;

    // Constructors

    public Report() {
    }

    public Report(int id, int userId, Date clockIn, Date clockOut, int projectID, int totalTime, String addedComment) {
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

    public Date getClockIn() {
        return clockIn;
    }

    public void setClockIn(Date clockIn) {
        this.clockIn = clockIn;
    }

    public Date getClockOut() {
        return clockOut;
    }

    public void setClockOut(Date clockOut) {
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
