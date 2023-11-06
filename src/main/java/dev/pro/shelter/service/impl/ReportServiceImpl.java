package dev.pro.shelter.service.impl;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import dev.pro.shelter.model.EnumResolution;
import dev.pro.shelter.model.Report;
import dev.pro.shelter.repository.ReportRepository;
import dev.pro.shelter.service.ReportService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository repository;
    private final TelegramBot telegramBot;

    public ReportServiceImpl(ReportRepository repository, TelegramBot telegramBot) {
        this.repository = repository;
        this.telegramBot = telegramBot;
    }

    @Override
    public void update(Report report) {
        repository.save(report);
    }

    @Override
    public List<Report> readAllDailyReport() {
        return repository.dailyReport();
    }

    @Override
    public void createWarning(long chatId, String warn) {
        switch (warn){
            case "insufficient":
                telegramBot.execute(new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что ты заполняешь отчет " +
                        "не так подробно, как необходимо. Пожалуйста, подойди ответственнее к этому занятию. " +
                        "В противном случае волонтеры приюта будут обязаны самолично проверять условия содержания животного"));
                break;
            case "missing":
                telegramBot.execute(new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что уже более двух дней" +
                        "ты не отправляешь нам отчет. Пожалуйста, подойди ответственнее к этому занятию, в противном случае " +
                        "волонтеры приюта будут обязаны самолично проверять условия содержания животного"));
        }
    }

    @Override
    public LocalDate readDailyReportMaxData(long idUsers){
        return repository.readDailyReportMaxDataParamsNative(idUsers);
    }

    @Override
    public List<Long> idAdoptersWithStatusParams(EnumResolution resolution){
        return repository.idAdoptersWithStatusParamsNative(resolution);
    }

//    @Override
//    public void isSent(){

    }

