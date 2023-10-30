package dev.pro.shelter.tools;

import org.springframework.scheduling.annotation.Scheduled;


public class Scheduler {
    @Scheduled(cron="0 0 21 * * *")
    public void CheckDailyReport(){
        // если нет отчета - отметка нет отчета,
        // если второй день - отметка два дня нет отчета,
        // если кончился срок подачи - отметка принять решение
        }
}
