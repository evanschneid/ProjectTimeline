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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
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

    @GetMapping("/login")
    public void redirectToGoogle(HttpServletResponse response) throws IOException {
        System.out.println("TESTING");
        response.sendRedirect("https://www.google.com");
    }

    @Autowired
    private JdbcUserDao jdbcUserDao;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        User user = jdbcUserDao.findByEmail(email);
        if (user == null) {
            // Create a new user
            user = new User();
            user.setUserEmail(email);
            user.setManager(true);
            user.setActivated(true);
            jdbcUserDao.save(user);
            return ResponseEntity.ok("New user created with email: " + email);
        } else {
            return ResponseEntity.ok("User already exists with email: " + email);
        }
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
