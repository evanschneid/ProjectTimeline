package com.techelevator.model;

public class User {
    private int id;
    private boolean isManager;
    private String userEmail;

    private boolean isActivated;

    // Constructors
    public User() {
    }

    public User(int id, boolean isManager, String userEmail) {
        this.id = id;
        this.isManager = isManager;
        this.userEmail = userEmail;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    // Methods


}
