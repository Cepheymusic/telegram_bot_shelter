package dev.pro.shelter.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import dev.pro.shelter.model.Contact;
import dev.pro.shelter.model.EnumsInfo;
import dev.pro.shelter.model.EnumsInfo2;
import dev.pro.shelter.repository.UsersRepository;
import dev.pro.shelter.service.KeyboardMarkup;
import dev.pro.shelter.service.TelegramBotService;
import dev.pro.shelter.service.UsersService;

import dev.pro.shelter.service.impl.TelegramBotServiceImpl;
import dev.pro.shelter.service.impl.UsersServiceImpl;
import dev.pro.shelter.tools.Parsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    private final TelegramBot telegramBot;
    private UsersService usersService;
    private UsersRepository usersRepository;
    private KeyboardMarkup keyboardMarkup;
    private TelegramBotService telegramBotService;

    public TelegramBotUpdatesListener(TelegramBot telegramBot,
                                      UsersService usersService,
                                      UsersRepository usersRepository,
                                      KeyboardMarkup keyboardMarkup,
                                      TelegramBotService telegramBotService
    ) {
        this.telegramBot = telegramBot;
        this.usersService = usersService;
        this.usersRepository = usersRepository;
        this.keyboardMarkup = keyboardMarkup;
        this.telegramBotService = telegramBotService;

    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);

            if (update.message() != null) {
                if (update.message().text().equals("/start")) {
                    long idChat = update.message().chat().id();
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup(
                            new InlineKeyboardButton("Приют для собак").callbackData("dogShelter"),
                            new InlineKeyboardButton("Приют для кошек").callbackData("catShelter"));
                    if (usersService.existsUserByChatId(idChat)) {
                        SendMessage messageForUser1 = new SendMessage(idChat, "Приветствуем старого знакомого. Выберите приют:")
                                .replyMarkup(markupInline);
                        telegramBot.execute(messageForUser1);
                    } else {
                        SendMessage messageForUser2 = new SendMessage(idChat, "Приветствуем нового гостя. Вы можете выбрать себе друга из приюта:")
                                .replyMarkup(markupInline);
                        usersService.createUser(update.message().chat().id());
                        telegramBot.execute(messageForUser2);
                    }
                }
                if (update.message().text().startsWith("/contact")) {
                    String contactMessage = update.message().text();
                    long idChat5 = update.message().chat().id();
                    telegramBotService.addContactToUser(contactMessage, idChat5);
                }
                if (update.message().text().startsWith("/report")) {
                    String reportMessage = update.message().text();
                    long idChat1 = update.message().chat().id();
                    telegramBotService.addReportToDB(idChat1, reportMessage);
                }



            }
            if (update.callbackQuery() != null) {
                String call_data = update.callbackQuery().data();
                var idChat = update.callbackQuery().message().chat().id();
                if (call_data.equals("dogShelter")) {
                    SendMessage messageForUser3 = new SendMessage(idChat, "Вы в меню приюта для собак").replyMarkup(keyboardMarkup.markupInlineDog());
                    telegramBot.execute(messageForUser3);
                } else if (call_data.equals("catShelter")) {
                    SendMessage messageForUser3 = new SendMessage(idChat, "Вы в меню приюта для кошек").replyMarkup(keyboardMarkup.markupInlineCat());
                    telegramBot.execute(messageForUser3);
                } else if (call_data.equals("infoDogShelter")) {
                    SendMessage messageShelterInfo = new SendMessage(idChat, EnumsInfo.INFO_SHELTER.getText()).replyMarkup(keyboardMarkup.markupInlineDogInfo());
                    telegramBot.execute(messageShelterInfo);
                } else if (call_data.equals("infoCatShelter")) {
                    SendMessage messageShelterInfo = new SendMessage(idChat, EnumsInfo.INFO_SHELTER.getText()).replyMarkup(keyboardMarkup.markupInlineCatInfo());
                    telegramBot.execute(messageShelterInfo);
                } else if (call_data.equals("searchDogShelter")) {
                    SendMessage messageSearchDogShelter = new SendMessage(idChat, EnumsInfo.SEARCH_DOG_SHELTER.getText());
                    telegramBot.execute(messageSearchDogShelter);
                } else if (call_data.equals("securityData")) {
                    SendMessage messageSecurityData = new SendMessage(idChat, EnumsInfo.SECURITY_DATA.getText());
                    telegramBot.execute(messageSecurityData);
                } else if (call_data.equals("safetyPrecautions")) {
                    SendMessage messageSafetyPrecautions = new SendMessage(idChat, EnumsInfo.SAFETY_PRECAUTIONS.getText());
                    telegramBot.execute(messageSafetyPrecautions);
                } else if (call_data.equals("sendContact")) {
                    SendMessage messageSendContact = new SendMessage(idChat, EnumsInfo.SEND_CONTACT.getText());
                    telegramBot.execute(messageSendContact);
                } else if (update.callbackQuery().data().equals("volunteer")) {
                    SendMessage messageVolunteer = new SendMessage(idChat, EnumsInfo.VOLUNTEER.getText());
                    telegramBot.execute(messageVolunteer);
                } else if (call_data.equals("datingRules")) {
                    SendMessage messageDatingRules = new SendMessage(idChat, EnumsInfo2.DATING_RULES.getText());
                    telegramBot.execute(messageDatingRules);
                } else if (call_data.equals("listOfDocuments")) {
                    SendMessage messageListOfDocuments = new SendMessage(idChat, EnumsInfo2.LIST_OF_DOCUMENTS.getText());
                    telegramBot.execute(messageListOfDocuments);
                } else if (call_data.equals("transportation")) {
                    SendMessage messageTransportation = new SendMessage(idChat, EnumsInfo2.TRANSPORTATION.getText());
                    telegramBot.execute(messageTransportation);
                } else if (call_data.equals("arrangingAPuppy")) {
                    SendMessage messageArrangingAPuppy = new SendMessage(idChat, EnumsInfo2.ARRANGING_A_PUPPY.getText());
                    telegramBot.execute(messageArrangingAPuppy);
                } else if (call_data.equals("arrangementOfAnAdultAnimal")) {
                    SendMessage messageArrangementOfAnAdultAnimal = new SendMessage(idChat, EnumsInfo2.ARRANGEMENT_OF_AN_ADULT_ANIMAL.getText());
                    telegramBot.execute(messageArrangementOfAnAdultAnimal);
                } else if (call_data.equals("limitedFeatures")) {
                    SendMessage messageLimitedFeatures = new SendMessage(idChat, EnumsInfo2.LIMITED_FEATURES.getText());
                    telegramBot.execute(messageLimitedFeatures);
                } else if (call_data.equals("dogHandler")) {
                    SendMessage messageDogHandler = new SendMessage(idChat, EnumsInfo2.DOG_HANDLER.getText());
                    telegramBot.execute(messageDogHandler);
                } else if (call_data.equals("provenDogHandlers")) {
                    SendMessage messageProvenDogHandlers = new SendMessage(idChat, EnumsInfo2.PROVEN_DOG_HANDLERS.getText());
                    telegramBot.execute(messageProvenDogHandlers);
                } else if (call_data.equals("reasonsForRefusal")) {
                    SendMessage messageReasonsForRefusal = new SendMessage(idChat, EnumsInfo2.REASONS_FOR_REFUSAL.getText());
                    telegramBot.execute(messageReasonsForRefusal);
                } else if (call_data.equals("sendDogReport")) {
                    SendMessage messageSampleReport = new SendMessage(idChat, EnumsInfo.SEND_REPORT.getText());
                    telegramBot.execute(messageSampleReport);
                }
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
