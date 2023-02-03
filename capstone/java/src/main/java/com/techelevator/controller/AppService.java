package com.techelevator.controller;
import com.techelevator.dao.JdbcProjectDao;
import com.techelevator.dao.JdbcReportDao;
import com.techelevator.dao.JdbcTaskDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.Project;
import com.techelevator.model.Report;
import com.techelevator.model.Task;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.techelevator.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.net.http.HttpClient;
import org.json.JSONObject;
import java.util.List;
import java.util.List;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
//@RequestMapping("/")
public class AppService {

        //final String url = "http://localhost:9000";

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
