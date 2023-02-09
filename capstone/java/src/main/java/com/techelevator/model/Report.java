package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Report {
    private int id;
    private int userid;
    private String clockin;
    private String clockout;
    private int projectid;
    private int totaltime;
    private String addedcomment;

    private String projecttitle;

    // Constructors

    public Report() {
    }

    public Report(int id, int userid, String clockin, String clockout, int projectid, int totaltime, String addedcomment, String projecttitle) {
        this.id = id;
        this.userid = userid;
        this.clockin = clockin;
        this.clockout = clockout;
        this.projectid = projectid;
        this.totaltime = totaltime;
        this.addedcomment = addedcomment;
        this.projecttitle = projecttitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getClockin() {
        return clockin;
    }

    public void setClockin(String clockin) {
        this.clockin = clockin;
    }

    public String getClockout() {
        return clockout;
    }

    public void setClockout(String clockout) {
        this.clockout = clockout;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public int getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(int totaltime) {
        this.totaltime = totaltime;
    }

    public String getAddedcomment() {
        return addedcomment;
    }

    public void setAddedcomment(String addedcomment) {
        this.addedcomment = addedcomment;
    }

    public String getProjecttitle() {
        return projecttitle;
    }

    public void setProjecttitle(String projecttitle) {
        this.projecttitle = projecttitle;
    }
}

