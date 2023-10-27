package dev.pro.shelter.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
// // <<<<<<< feature-2
// // import dev.pro.shelter.service.impl.UsersServiceImpl;
// // =======
// // >>>>>>> dev
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Service;

// import javax.annotation.PostConstruct;
// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class TelegramBotUpdatesListener implements UpdatesListener {
//     private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
// // <<<<<<< feature-2
// //     private final TelegramBot telegramBot;
// //     private UsersServiceImpl userService;

// //     public TelegramBotUpdatesListener(TelegramBot telegramBot, UsersServiceImpl userService) {
// //         this.telegramBot = telegramBot;
// //         this.userService = userService;
// //     }

// // //    public TelegramBotUpdatesListener(TelegramBot telegramBot) {
// // //        this.telegramBot = telegramBot;
// // //    }
// // =======

// //     private final TelegramBot telegramBot;
// //     public TelegramBotUpdatesListener(TelegramBot telegramBot) {
// //         this.telegramBot = telegramBot;
// //     }
// // >>>>>>> dev

//     @PostConstruct
//     public void init() {
//         telegramBot.setUpdatesListener(this);
//     }

//     @Override
//     public int process(List<Update> updates) {
//         updates.forEach(update -> {
//             logger.info("Processing update: {}", update);
// ?
//             }
// //            else if (update.callbackQuery().data().equals("dogShelter")) {
// //
// //            }

        });

        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void replyToMessage(Update update, String text) {
        telegramBot.execute(new SendMessage(update.message().chat().id(), text));
    }
}
