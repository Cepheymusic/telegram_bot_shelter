package dev.pro.shelter.service;

import dev.pro.shelter.model.EnumResolution;
import dev.pro.shelter.model.Report;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    void update(Report report);
    List<Report> readAllDailyReport();
    void createWarning(long id, String warn);
//    LocalDate readLastDate(long id);

    LocalDate readDailyReportMaxData(long idUsers);
    List<Long> idAdoptersWithStatusParams(EnumResolution resolution);
}
