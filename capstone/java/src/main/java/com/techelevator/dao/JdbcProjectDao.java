package com.techelevator.dao;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Project;

@Component
public class JdbcProjectDao implements ProjectDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcProjectDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String sql = "select * from projects";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Project project = mapRowToProject(results);
            projects.add(project);
        }

        return projects;
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
    public void insertProject(Project project) {

    }

    @Override
    public void updateProject(Project project) {

    }

    @Override
    public void deleteProject(int id) {

    }

    private Project mapRowToProject(SqlRowSet rs) {
        Project project = new Project();
        project.setId(rs.getInt("project_id"));
        /*project.setName(rs.getString("name"));
        project.setDescription(rs.getString("description"));
        project.setStartDate(rs.getDate("start_date").toLocalDate());
        project.setEndDate(rs.getDate("end_date").toLocalDate());*/

        return project;
    }
}
