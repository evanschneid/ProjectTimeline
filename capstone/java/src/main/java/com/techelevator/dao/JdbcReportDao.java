package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Report;

@Component
public class JdbcReportDao implements ReportDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReportDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Temp method

    @Override
    public void createReport(Report report) {

    }


   /* @Override
    public void createReport(Report report) {
        String sqlInsertReport = "INSERT INTO reports (project_id, title, description, user_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sqlInsertReport, report.getProjectId(), report.getTitle(), report.getDescription(), report.getUserId());
    }*/

    @Override
    public Report getReportById(int id) {
        return null;
    }

    @Override
    public List<Report> getReportsByProjectId(int projectId) {
        List<Report> reports = new ArrayList<>();
        String sqlGetReportsByProjectId = "SELECT * FROM reports WHERE project_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetReportsByProjectId, projectId);
        while (results.next()) {
            Report report = mapRowToReport(results);
            reports.add(report);
        }
        return reports;
    }

    @Override
    public List<Report> getAllReports() {
        return null;
    }

    @Override
    public void updateReport(Report report) {

    }

    @Override
    public void deleteReport(int id) {

    }

    private Report mapRowToReport(SqlRowSet results) {
        Report report = new Report();
        report.setId(results.getInt("id"));
        /*report.setProjectId(results.getInt("project_id"));
        report.setTitle(results.getString("title"));
        report.setDescription(results.getString("description"));*/
        report.setUserId(results.getInt("user_id"));
        return report;
    }

}
