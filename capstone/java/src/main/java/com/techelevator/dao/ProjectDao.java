package com.techelevator.dao;

import com.techelevator.model.Project;

import java.util.List;

public interface ProjectDao {
    void insertProject(Project project);
    Project getProjectById(int id);
    List<Project> getAllProjects();
    void updateProject(Project project);
    void deleteProject(int id);
}