package com.techelevator.controller;
import com.techelevator.dao.JdbcProjectDao;
import com.techelevator.dao.JdbcReportDao;
import com.techelevator.dao.JdbcTaskDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.Project;
import com.techelevator.model.Report;
import com.techelevator.model.Task;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AppService {

        @Autowired
        private JdbcUserDao userDao;

        @Autowired
        private JdbcProjectDao projectDao;

        @Autowired
        private JdbcTaskDao taskDao;

        @Autowired
        private JdbcReportDao reportDao;

      /*  @PostMapping("/login")
        public User login(@RequestBody User user) {
            return userDao.login(user);
        }*/

        @GetMapping("/projects")
        public List<Project> getAllProjects() {
            return projectDao.getAllProjects();
        }

        @GetMapping("/projects/{id}")
        public Project getProjectById(@PathVariable int id) {
            return projectDao.getProjectById(id);
        }

        @GetMapping("/tasks")
        public List<Task> getAllTasks() {
            return taskDao.getAllTasks();
        }

        @GetMapping("/worklog")
        public List<Report> getAllReports() {
            return reportDao.getAllReports();
        }

        @GetMapping("/worklog/{id}")
        public Report getWorklogById(@PathVariable int id) {
            return reportDao.getReportById(id);
        }
    }
