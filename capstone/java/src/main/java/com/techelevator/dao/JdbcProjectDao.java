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

//        while (results.next()) {
//            for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
//                System.out.print(results.getObject(i) + " ");
//            }
//            System.out.println();
//        }

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
