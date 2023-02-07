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
        String sqlGetReportsByProjectId = "SELECT * FROM worklog WHERE projectid = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetReportsByProjectId, projectId);
        while (results.next()) {
            Report report = mapRowToWorkLog(results);
            reports.add(report);
        }
        return reports;
    }

    @Override
    public List<Report> getAllReports() {
        String sql = "SELECT * FROM worklog";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Report> reportList = new ArrayList<>();
        while (results.next()) {
            Report report = mapRowToWorkLog(results);
            reportList.add(report);
        }
        return reportList;
    }

    @Override
    public void updateReport(Report report) {

    }

    @Override
    public void deleteReport(int id) {

    }

    private Report mapRowToWorkLog(SqlRowSet results) {
        Report workLog = new Report();
        workLog.setId(results.getInt("logid"));
        workLog.setUserId(results.getInt("userid"));
        workLog.setClockIn(results.getTimestamp("clockin").toLocalDateTime());
        workLog.setClockOut(results.getTimestamp("clockout").toLocalDateTime());
        workLog.setProjectID(results.getInt("projectid"));
        //workLog.setTotalTime(results.getInt("totaltime"));
        return workLog;
    }


}
