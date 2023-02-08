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
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

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


    // User ****************************************************************

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

    @GetMapping("/user")
    public ResponseEntity<Map<String, Object>> getUserByEmail(@RequestParam("email") String email) {
        User user = jdbcUserDao.getUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("ismanager", user.isManager());
            response.put("isactivated", user.isActivated());
            response.put("userid", user.getId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    //Projects ********************************************************************

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @CrossOrigin
    @GetMapping("/projects/{userid}")
    public List<Project> getProjectByUserId(@PathVariable int userid) {
        return projectDao.getProjectsByUserId(userid);
    }

    @GetMapping("/singleProject/{projectid}")
    public ResponseEntity<List<Project>> getAllProjectByProjectId(@PathVariable int projectid) {
        List<Project> projects = projectDao.getAllProjectsByProjectId(projectid);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/projects")
    public ResponseEntity<Object> addProject(@RequestBody Project project) {
        projectDao.addProject(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        projectDao.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/editProject")
    public ResponseEntity<Void> updateProject(@RequestBody Project project) {
        projectDao.updateProject(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //Tasks *******************************************

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }

//    @GetMapping("/tasks/{userId}/{projectId}/{taskId}")
//    public ResponseEntity<Task> getAllTasksByTaskId(@PathVariable int userId, @PathVariable int projectId, @PathVariable int taskId) {
//        Task task = taskDao.getAllTasksByTaskId(userId, projectId, taskId);
//        return new ResponseEntity<>(task, HttpStatus.OK);
//    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<Task> getAllTasksByTaskId(@PathVariable int taskId) {
        Task task = taskDao.getAllTasksByTaskId(taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/singletask/{projectId}")
    public ResponseEntity<List<Task>> getAllTasksByProjectId(@PathVariable int projectId) {
        List<Task> tasks = taskDao.getAllTasksByProjectId(projectId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/task")
    public ResponseEntity<Void> addTask(@RequestBody Task task) {
        taskDao.addTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/task")
    public ResponseEntity<Void> updateTask(@RequestBody Task task) {
        taskDao.updateTask(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable int taskId) {
        taskDao.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    //Worklog **********************************************************************



    @GetMapping("/worklog")
    public List<Report> getAllReports() {
        return reportDao.getAllReports();
    }

    @GetMapping("/worklog/{id}")
    public Report getWorklogById(@PathVariable int id) {
        return reportDao.getReportById(id);
    }

    @GetMapping("/worklog/user/{userId}")
    public ResponseEntity<List<Report>> getAllReportsByUser(@PathVariable int userId) {
        List<Report> reports = reportDao.getAllReportsByUser(userId);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/worklog/{userId}/{projectId}")
    public ResponseEntity<List<Report>> getAllReportsForUserByProjectId(@PathVariable int userId, @PathVariable int projectId) {
        List<Report> reports = reportDao.getAllReportsForUserByProjectId(userId, projectId);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @PostMapping("/worklog")
    public ResponseEntity<Report> createReport(@RequestBody Report report) {

        reportDao.createReport(report);
        return new ResponseEntity<>(report, HttpStatus.CREATED);
    }

    @PutMapping("/worklog/{reportId}")
    public ResponseEntity<Report> updateReport(@PathVariable int reportId, @RequestBody Report report) {
        reportDao.updateReport(reportId, report);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @DeleteMapping("/worklog/{reportId}")
    public ResponseEntity<Void> deleteReport(@PathVariable int reportId) {
        reportDao.deleteReport(reportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    


}
