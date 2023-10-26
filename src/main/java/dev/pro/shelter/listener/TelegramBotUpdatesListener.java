package dev.pro.shelter.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import dev.pro.shelter.service.impl.UsersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
    private final TelegramBot telegramBot;
    private UsersServiceImpl userService;

    public TelegramBotUpdatesListener(TelegramBot telegramBot, UsersServiceImpl userService) {
        this.telegramBot = telegramBot;
        this.userService = userService;
    }

//    public TelegramBotUpdatesListener(TelegramBot telegramBot) {
//        this.telegramBot = telegramBot;
//    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            // Process your updates here
            String message = update.message().text();
            if (update.message() == null) {
                logger.error("Message is null");
                return;
            } else {
                logger.info("Processing message: \"{}\"", message);
            }

            if (message==null)
            {return;}

            if (message.equals("/start")) {
                long idChat = update.message().chat().id();
                if (userService.existsUserByChatId(idChat)) {
                    replyToMessage(update, "Приветствуем старого знакомого! Выбери, пожалуйста, приют для " +
                            "продолжения работы");
                } else {
                    replyToMessage(update, "Приветствуем нового гостя! Наш бот поможет тебе выбрать друга из приюта. " +
                            "Для продолжения работы выбери, пожалуйста, приют");
                    userService.createUser(update.message().chat().id());
                }

//                SendMessage message = new SendMessage(idChat, "You send /start");
//                telegramBot.execute(message);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void replyToMessage(Update update, String text) {
        telegramBot.execute(new SendMessage(update.message().chat().id(), text));
    }
}
