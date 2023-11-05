package dev.pro.shelter.tools;

import dev.pro.shelter.model.Report;
import dev.pro.shelter.service.*;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class Scheduler {
    private final ReportService reportService;
    private final TelegramBotService botService;
    private final VolunteerService volunteerService;


    public Scheduler(ReportService reportService, TelegramBotService botService, VolunteerService volunteerService) {
        this.reportService = reportService;
        this.botService = botService;

        this.volunteerService = volunteerService;
    }

    @Scheduled(cron = "0 0 21 * * *")
    public void AnalyzeDailyReport() {
        List<Report> dailyReports = reportService.readAllDailyReport();
        for (Report reports : dailyReports) {
            if ((reportService.readDailyReportMaxData(reports.getIdUsers()).until(LocalDate.now(), ChronoUnit.DAYS)) < 2) {
                botService.sendMessageFromReportManagement(reports.getIdUsers(), "Дорогой усыновитель,вы пропустили время " +
                        "отправки ежедневного отчета о вашем питомце. Пожалуйста будьте аккуратнее и не забывайте отправить отчет " +
                        "по образцу своевременно!");
            } else {
                botService.sendMessageFromReportManagement(volunteerService.getRandomVolunteerChatId(),"Два дня и более не поступает отчет от пользователя" +
                        "с idUser " + reports.getIdUsers());
            }
        }
    }

//    @Scheduled(cron = "0 30 23 * * *")
//    public void AnalyzeStatusReport() {

////        reportService.idAdoptersWithStatusParamsNative(resolution);
////        for (Report reports : dailyReports) {
////            if ((reportService.readDailyReportMaxData(reports.getIdUsers()).until(LocalDate.now(), ChronoUnit.DAYS)) < 2) {
//
//
//            } else {
//
//            }
//        }
//    }


//    @Scheduled(cron="0 0/1 * * * *")
//    public void NotificationSentNow(){
//        LocalDateTime dateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
//        Collection<NotificationTask> tasks_now = repository.findByDateTime(dateTime);
//        for(NotificationTask task:tasks_now){
//            logger.info("sending task {}",task);
//            var response = new SendMessage(task.getChatId(),task.getNotification());
//            telegramBot.execute(response);
//            task.setSent(true);
//            repository.save(task);
//        }
//    }
}
