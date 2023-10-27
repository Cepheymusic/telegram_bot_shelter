package dev.pro.shelter.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    private final TelegramBot telegramBot;
    public TelegramBotUpdatesListener(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }
    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            if (update.message().text().equals("/start")) {
                long idChat = update.message().chat().id();
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup(
                        new InlineKeyboardButton("Приют для собак").callbackData("dogShelter"),
                        new InlineKeyboardButton("Приют для кошек").callbackData("catShelter")
                );
                SendMessage message = new SendMessage(idChat, "Добро пожаловать в наш мир кошечек и собачек. Выберите приют")
                        .replyMarkup(markupInline);
                telegramBot.execute(message);
            }
//            else if (update.callbackQuery().data().equals("dogShelter")) {
//
//            }

        });

        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
