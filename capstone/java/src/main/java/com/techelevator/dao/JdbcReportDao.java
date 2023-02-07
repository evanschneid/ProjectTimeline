package com.techelevator.dao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    public void createReport(Report report) {



        String sql = "INSERT INTO worklog (userid, clockin, clockout, projectid) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, report.getUserId(), report.getClockIn(), report.getClockOut(), report.getProjectId());


    }


   /* @Override
    public void createReport(Report report) {
        String sqlInsertReport = "INSERT INTO reports (project_id, title, description, user_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sqlInsertReport, report.getProjectId(), report.getTitle(), report.getDescription(), report.getUserId());
    }*/

    @Override
    public Report getReportById(int reportId) {
        String sql = "SELECT * FROM worklog WHERE logid = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reportId);
        if(results.next()) {
            return mapRowToWorkLog(results);
        } else {
            return null;
        }
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

    public List<Report> getAllReportsByUser(int userId) {
        String sql = "SELECT * FROM worklog WHERE userid = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        List<Report> workLogs = new ArrayList<>();
        while (results.next()) {
            workLogs.add(mapRowToWorkLog(results));
        }

        return workLogs;
    }

    public List<Report> getAllReportsForUserByProjectId(int userId, int projectId) {
        List<Report> reports = new ArrayList<>();
        String sql = "SELECT * FROM worklog WHERE userid = ? AND projectid = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, projectId);
        while (results.next()) {
            reports.add(mapRowToWorkLog(results));
        }
        return reports;
    }




    @Override
    public List<Report> getAllReports() {
        String sql = "SELECT w.*, p.projecttitle FROM worklog w JOIN project p ON w.projectid = p.projectid";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Report> reportList = new ArrayList<>();
        while (results.next()) {
            Report report = mapRowToWorkLog(results);
            report.setProjectTitle(results.getString("projecttitle"));
            reportList.add(report);
        }
        return reportList;
    }


    public void updateReport(int reportId, Report report) {
        String sql = "UPDATE worklog SET clockin = ?, clockout = ?, projectid = ? WHERE logid = ?";
        jdbcTemplate.update(sql, report.getClockIn(), report.getClockOut(), report.getProjectId(), reportId);
    }


    public void deleteReport(int reportId) {
        String sql = "DELETE FROM worklog WHERE logid = ?";
        jdbcTemplate.update(sql, reportId);
    }


    private Report mapRowToWorkLog(SqlRowSet results) {
        Report workLog = new Report();
        workLog.setId(results.getInt("logid"));
        workLog.setUserId(results.getInt("userid"));
        workLog.setClockIn(results.getTimestamp("clockin").toLocalDateTime());
        workLog.setClockOut(results.getTimestamp("clockout").toLocalDateTime());
        workLog.setProjectID(results.getInt("projectid"));

        LocalDateTime clockIn = workLog.getClockIn();
        LocalDateTime clockOut = workLog.getClockOut();
        long hours = ChronoUnit.HOURS.between(clockIn, clockOut);
        long minutes = ChronoUnit.MINUTES.between(clockIn, clockOut) - (hours * 60);
        long totalTime = (hours * 60) + minutes;

        workLog.setTotalTime(totalTime);

        return workLog;
    }


    }
