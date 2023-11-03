package dev.pro.shelter.service.impl;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import dev.pro.shelter.listener.TelegramBotUpdatesListener;
import dev.pro.shelter.model.Contact;
import dev.pro.shelter.repository.UsersRepository;
import dev.pro.shelter.service.TelegramBotService;
import dev.pro.shelter.service.UsersService;
import dev.pro.shelter.tools.Parsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TelegramBotServiceImpl implements TelegramBotService {

    private Logger logger = LoggerFactory.getLogger(TelegramBotServiceImpl.class);

    private final TelegramBot telegramBot;
    private final UsersService usersService;


    public TelegramBotServiceImpl(TelegramBot telegramBot,
                                  UsersService usersService) {
        this.telegramBot = telegramBot;
        this.usersService = usersService;
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
            result = new SendMessage(idChat, "incorrect data format");
            telegramBot.execute(result);
            logger.warn("from chat with id {} was sent incorrect request {}, notification not created", idChat, contactMessage);
            return;
        }
        usersService.updateUser(user);
        result = new SendMessage(idChat, "Данные сохранены");
        telegramBot.execute(result);
        logger.info("for chat with id {} was created notification {}", idChat, contactMessage);
    }
}
