package dev.pro.shelter.service;

import dev.pro.shelter.model.Report;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    void update(Report report);
    List<Report> readAllDailyReport();
    void createWarning(long id, String warn);
    LocalDate readLastDate();
}
