package com.techelevator.dao;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Project;

//isshared in the helper method needs to be fixed. It causes the request to fail as of now

@Component
public class JdbcProjectDao implements ProjectDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcProjectDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }




    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String sql = "select * from project";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Project project = mapRowToProject(results);
            projects.add(project);
        }

        return projects;
    }

    public List<Project> getProjectsByUserId(int userId) {
        List<Project> projects = new ArrayList<>();
        String sql = "select * from project where userid = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            Project project = mapRowToProject(results);
            projects.add(project);
        }

        return projects;
    }

    public List<Project> getAllProjectsByProjectId(int projectId) {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM project WHERE projectid = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

        while (results.next()) {
            Project project = mapRowToProject(results);
            projects.add(project);
        }

        return projects;
    }

    public void addProject(Project project) {
        String sql = "INSERT INTO project (projecttitle, projectdescription, projectimg, projectiscompleted, projectduedate) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, project.getProjectTitle(), project.getProjectDescription(), project.getProjectImg(), project.isProjectIsCompleted(), project.getProjectDueDate());
    }

    @Override
    public Project getProjectById(int id) {
        String sql = "SELECT * FROM projects WHERE project_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToProject(results);
        } else {
            return null;
        }
    }

    @Override
    public void deleteProject(int id) {
        String sql = "DELETE FROM project WHERE projectid = ?";
        jdbcTemplate.update(sql, id);
    }
    @Override
    public void updateProject(Project project, int id) {

        String sql = "UPDATE project SET projecttitle = ?, projectdescription = ?, projectimg = ?, projectiscompleted = ?, projectduedate = ?, projectcompletiondate = ? WHERE projectid = ?";
        jdbcTemplate.update(sql, project.getProjectTitle(), project.getProjectDescription(), project.getProjectImg(), project.isProjectIsCompleted(), project.getProjectDueDate(), project.getProjectCompletionDate(), project.getId());
    }

    private Project mapRowToProject(SqlRowSet rs) {
        Project project = new Project();
        project.setId(rs.getInt("projectid"));
        project.setProjectTitle(rs.getString("projecttitle"));
        project.setProjectDescription(rs.getString("projectdescription"));
        project.setProjectImg(rs.getString("projectimg"));
        project.setProjectIsCompleted(rs.getBoolean("projectiscompleted"));
        project.setProjectDueDate(rs.getDate("projectduedate"));
        project.setProjectCompletionDate(rs.getDate("projectcompletiondate"));
        project.setUserId(rs.getInt("userid"));
//        project.setShared(rs.getBoolean("ishared"));
        return project;
    }


    public String sqlString(SqlRowSet results) {
        StringBuilder sb = new StringBuilder();
        while (results.next()) {
            for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
                sb.append(results.getObject(i));
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
