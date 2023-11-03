package dev.pro.shelter.tools;

import org.springframework.scheduling.annotation.Scheduled;


public class Scheduler {
    @Scheduled(cron = "0 0 21 * * *")
    public void CheckDailyReport() {

    }
}
