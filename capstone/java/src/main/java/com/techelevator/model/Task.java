package com.techelevator.model;

import java.util.Date;

public class Task {
    private int id;
    private String tasktitle;
    private String taskdescription;
    private boolean tasksscompleted;
    private String taskduedate;
    private String taskcompletiondate;
    private int projectid;

    // Constructors

    public Task() {

    }

    public Task(int id, String tasktitle, String taskdescription, boolean tasksscompleted, String taskduedate, String taskcompletiondate, int projectid) {
        this.id = id;
        this.tasktitle = tasktitle;
        this.taskdescription = taskdescription;
        this.tasksscompleted = tasksscompleted;
        this.taskduedate = taskduedate;
        this.taskcompletiondate = taskcompletiondate;
        this.projectid = projectid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    public String getTaskdescription() {
        return taskdescription;
    }

    public void setTaskdescription(String taskdescription) {
        this.taskdescription = taskdescription;
    }

    public boolean isTasksscompleted() {
        return tasksscompleted;
    }

    public void setTasksscompleted(boolean tasksscompleted) {
        this.tasksscompleted = tasksscompleted;
    }

    public String getTaskduedate() {
        return taskduedate;
    }

    public void setTaskduedate(String taskduedate) {
        this.taskduedate = taskduedate;
    }

    public String getTaskcompletiondate() {
        return taskcompletiondate;
    }

    public void setTaskcompletiondate(String taskcompletiondate) {
        this.taskcompletiondate = taskcompletiondate;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }
}
