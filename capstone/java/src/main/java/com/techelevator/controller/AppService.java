package com.techelevator.controller;
import com.techelevator.dao.JdbcProjectDao;
import com.techelevator.dao.JdbcReportDao;
import com.techelevator.dao.JdbcTaskDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.Project;
import com.techelevator.model.Report;
import com.techelevator.model.Task;
import com.techelevator.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
//@RequestMapping("/")
public class AppService {

        final String url = "http://localhost:9000";

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

    @GetMapping("/login")
    public void redirectToGoogle(HttpServletResponse response) throws IOException {
        System.out.println("TESTING");
        response.sendRedirect("https://www.google.com");
    }

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
