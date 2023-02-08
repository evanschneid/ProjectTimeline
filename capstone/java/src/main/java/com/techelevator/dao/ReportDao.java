package com.techelevator.dao;

import com.techelevator.model.Report;

import java.util.List;

public interface ReportDao {
    void createReport(Report report);
    Report getReportById(int id);
    List<Report> getReportsByProjectId(int projectId);
    List<Report> getAllReports();
    void deleteReport(int id);
}
