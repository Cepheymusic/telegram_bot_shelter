package dev.pro.shelter.tools;

import dev.pro.shelter.service.ReportService;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;


public class Scheduler {
    private final ReportService reportService;

    public Scheduler(ReportService reportService) {
        this.reportService = reportService;
    }

    @Scheduled(cron = "0 0 21 * * *")
    public void AnalyzeDailyReport() {
if(LocalDate.now()<reportService.)
    }
}
