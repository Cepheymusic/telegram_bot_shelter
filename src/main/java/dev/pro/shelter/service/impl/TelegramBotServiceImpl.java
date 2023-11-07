package dev.pro.shelter.service.impl;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import dev.pro.shelter.model.Contact;
import dev.pro.shelter.model.Report;
import dev.pro.shelter.service.ReportService;
import dev.pro.shelter.service.TelegramBotService;
import dev.pro.shelter.service.UsersService;
import dev.pro.shelter.tools.Parsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TelegramBotServiceImpl implements TelegramBotService {

    private Logger logger = LoggerFactory.getLogger(TelegramBotServiceImpl.class);

    private final TelegramBot telegramBot;
    private final UsersService usersService;
    private final ReportService reportService;
    private final DogAdopterServiceImpl dogAdopterService;
    private final CatAdopterServiceImpl catAdopterService;


    public TelegramBotServiceImpl(TelegramBot telegramBot,
                                  UsersService usersService,
                                  ReportService reportService,
                                  DogAdopterServiceImpl dogAdopterService,
                                  CatAdopterServiceImpl catAdopterService) {
        this.telegramBot = telegramBot;
        this.usersService = usersService;
        this.reportService = reportService;
        this.dogAdopterService = dogAdopterService;
        this.catAdopterService = catAdopterService;
    }

    @Override
    public void addContactToUser(String contactMessage, long idChat) {
        var user = usersService.findByChatId(idChat);
        SendMessage result;
        try {
            Contact contact = Parsers.parseContact(contactMessage);
            user.setContact(contact);
            usersService.updateUser(user);
        } catch (Exception ex) {
            result = new SendMessage(idChat, "Ошибка формата данных");
            telegramBot.execute(result);
            logger.warn("from chat with id {} was sent incorrect request {}, cotnact data was not saved", idChat, contactMessage);
            return;
        }
        usersService.updateUser(user);
        result = new SendMessage(idChat, "Данные сохранены");
        telegramBot.execute(result);
        logger.info("for chat with id {} contact data was saved {}", idChat, contactMessage);
    }

    @Override
    public void addReportToDB(long idChat, String caption) {
        Report report = new Report();
        SendMessage result;
        try {
            long adopterId = catAdopterService.readCatAdopterIdFromChatId(idChat);
            LocalDate reportDate = LocalDate.now();
            if (catAdopterService.existsCatAdopterByChatId(idChat)) {
                LocalDate lastReportDate = catAdopterService.readStartDate(adopterId).plusDays(30);
                report.setLastReportDate(lastReportDate);
            } else if
            (catAdopterService.existsCatAdopterByChatId(idChat)) {
                LocalDate lastReportDate = dogAdopterService.readStartDate(adopterId).plusDays(30);
                report.setLastReportDate(lastReportDate);
            }
            Byte[] photo = new Byte[]{};//тут метод, вынимающий фото из ТгБота
            String[] reportText = Parsers.parseReportText(caption);
            String diet = reportText[0];
            String health = reportText[1];
            String habits = reportText[2];
            report.getUsers().setIdUsers(adopterId);
            report.setReportDate(reportDate);
//            report.setLastReportDate(lastReportDate);
            report.setPhoto(photo);
            report.setDiet(diet);
            report.setHealth(health);
            report.setHabits(habits);
        } catch (Exception ex) {
            result = new SendMessage(idChat, "Ошибка формата данных");
            telegramBot.execute(result);
            logger.warn("from chat with id {} was sent incorrect request {}, report was not saved", idChat, caption);
            return;
        }
        reportService.update(report);
        result = new SendMessage(idChat, "Отчет сохранен");
        telegramBot.execute(result);
        logger.info("for chat with id {} contact data was saved {}", idChat, caption);
    }

    @Override
    public void sendMessageFromReportManagement(long idChat, String text) {
        telegramBot.execute(new SendMessage(idChat, text));
    }
}
