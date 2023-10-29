package dev.pro.shelter.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import dev.pro.shelter.Exception.MessageNotFound;
import dev.pro.shelter.model.Contact;
import dev.pro.shelter.model.EnumsInfo;
import dev.pro.shelter.model.EnumsInfo2;
import dev.pro.shelter.repository.UsersRepository;
import dev.pro.shelter.service.ContactService;
import dev.pro.shelter.service.UsersService;
import dev.pro.shelter.tools.Parsers;
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
    private UsersService usersService;
    private UsersRepository usersRepository;


    public TelegramBotUpdatesListener(TelegramBot telegramBot,
                                      UsersService usersService,
                                      UsersRepository usersRepository) {
        this.telegramBot = telegramBot;
        this.usersService = usersService;
        this.usersRepository = usersRepository;

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
            }
            InlineKeyboardMarkup markupInline2 = new InlineKeyboardMarkup();
            markupInline2.addRow(new InlineKeyboardButton("Рассказать о приюте").callbackData("infoShelter"),
                    new InlineKeyboardButton("Расписание работы, адрес").callbackData("searchDogShelter"));
            markupInline2.addRow(new InlineKeyboardButton("Контактные данные охраны для оформления пропуска на машину").callbackData("securityData"));
            markupInline2.addRow(new InlineKeyboardButton("Рекомендации о технике безопасности на территории приюта").callbackData("safetyPrecautions"));
            markupInline2.addRow(new InlineKeyboardButton("Позвать волонтёра").callbackData("volunteer"),
                    new InlineKeyboardButton("Отправить контактные данные").callbackData("sendContact"));

            if (update.callbackQuery() != null) {
                String call_data = update.callbackQuery().data();
                var idChat = update.callbackQuery().message().chat().id();
                if (call_data.equals("dogShelter")) {
                    SendMessage messageForUser3 = new SendMessage(idChat, "Вы в меню приюта для собак").replyMarkup(markupInline2);
                    telegramBot.execute(messageForUser3);
                }
            }
            if (update.callbackQuery() != null) {
                String call_data = update.callbackQuery().data();
                var idChat = update.callbackQuery().message().chat().id();
                if (call_data.equals("catShelter")) {
                    SendMessage messageForUser3 = new SendMessage(idChat, "Вы в меню приюта для кошек").replyMarkup(markupInline2);
                    telegramBot.execute(messageForUser3);
                }
            }
            if (update.callbackQuery() != null) {
                String call_data2 = update.callbackQuery().data();
                var idChat2 = update.callbackQuery().message().chat().id();
                if (call_data2.equals("infoShelter")) {
                    InlineKeyboardMarkup markupInline3 = new InlineKeyboardMarkup(
                            new InlineKeyboardButton("Правила знакомства с животным").callbackData("datingRules"));
                    markupInline3.addRow(new InlineKeyboardButton("Список документов, необходимых для того, чтобы взять животное из приюта").callbackData("listOfDocuments"));
                    markupInline3.addRow(new InlineKeyboardButton("Список рекомендаций по транспортировке животного").callbackData("transportation"));
                    markupInline3.addRow(new InlineKeyboardButton("Список рекомендаций по обустройству дома для маленького животного").callbackData("arrangingAPuppy"));
                    markupInline3.addRow(new InlineKeyboardButton("Список рекомендаций по обустройству дома для взрослого животного").callbackData("arrangementOfAnAdultAnimal"));
                    markupInline3.addRow(new InlineKeyboardButton("Список рекомендаций по обустройству дома для животного с ограниченными возможностями").callbackData("limitedFeatures"));
                    markupInline3.addRow(new InlineKeyboardButton("Советы кинолога по первичному общению с собакой").callbackData("dogHandler"));
                    markupInline3.addRow(new InlineKeyboardButton("Рекомендации по проверенным кинологам для дальнейшего обращения к ним").callbackData("provenDogHandlers"));
                    markupInline3.addRow(new InlineKeyboardButton("Причины, по которым могут отказать и не дать забрать животное из приюта.").callbackData("reasonsForRefusal"));
                    markupInline3.addRow(new InlineKeyboardButton("Принять и записать контактные данные для связи").callbackData("sendContact"));
                    markupInline3.addRow(new InlineKeyboardButton("Позвать волонтёра").callbackData("volunteer"));
                    SendMessage messageShelterInfo = new SendMessage(idChat2, EnumsInfo.INFO_DOG_SHELTER.getText()).replyMarkup(markupInline3);
                    telegramBot.execute(messageShelterInfo);
                } else if (call_data2.equals("searchDogShelter")) {
                    SendMessage messageSearchDogShelter = new SendMessage(idChat2, EnumsInfo.SEARCH_DOG_SHELTER.getText());
                    telegramBot.execute(messageSearchDogShelter);
                } else if (call_data2.equals("securityData")) {
                    SendMessage messageSecurityData = new SendMessage(idChat2, EnumsInfo.SECURITY_DATA.getText());
                    telegramBot.execute(messageSecurityData);
                } else if (call_data2.equals("safetyPrecautions")) {
                    SendMessage messageSafetyPrecautions = new SendMessage(idChat2, EnumsInfo.SAFETY_PRECAUTIONS.getText());
                    telegramBot.execute(messageSafetyPrecautions);
                } else if (call_data2.equals("sendContact")) {
                    SendMessage messageSendContact = new SendMessage(idChat2, EnumsInfo.SEND_CONTACT.getText());
                    telegramBot.execute(messageSendContact);
                    String contactMessage = update.message().text();
                    if (contactMessage.isEmpty()) {
                        throw new RuntimeException();
                    } else {
                        addContactToUser(contactMessage, idChat2);
                        SendMessage dataRecordingMessage = new SendMessage(idChat2, "Данные сохранены");
                        telegramBot.execute(dataRecordingMessage);
                    }
                } else if (update.callbackQuery().data().equals("volunteer")) {
                    SendMessage messageVolunteer = new SendMessage(idChat2, EnumsInfo.VOLUNTEER.getText());
                    telegramBot.execute(messageVolunteer);
                }
            }
            if (update.callbackQuery() != null) {
                String call_data2 = update.callbackQuery().data();
                var idChat3 = update.callbackQuery().message().chat().id();
                if (call_data2.equals("datingRules")) {
                    SendMessage messageDatingRules = new SendMessage(idChat3, EnumsInfo2.DATING_RULES.getText());
                    telegramBot.execute(messageDatingRules);
                } else if (call_data2.equals("listOfDocuments")) {
                    SendMessage messageListOfDocuments = new SendMessage(idChat3, EnumsInfo2.LIST_OF_DOCUMENTS.getText());
                    telegramBot.execute(messageListOfDocuments);
                } else if (call_data2.equals("transportation")) {
                    SendMessage messageTransportation = new SendMessage(idChat3, EnumsInfo2.TRANSPORTATION.getText());
                    telegramBot.execute(messageTransportation);
                } else if (call_data2.equals("arrangingAPuppy")) {
                    SendMessage messageArrangingAPuppy = new SendMessage(idChat3, EnumsInfo2.ARRANGING_A_PUPPY.getText());
                    telegramBot.execute(messageArrangingAPuppy);
                } else if (call_data2.equals("arrangementOfAnAdultAnimal")) {
                    SendMessage messageArrangementOfAnAdultAnimal = new SendMessage(idChat3, EnumsInfo2.ARRANGEMENT_OF_AN_ADULT_ANIMAL.getText());
                    telegramBot.execute(messageArrangementOfAnAdultAnimal);
                } else if (call_data2.equals("limitedFeatures")) {
                    SendMessage messageLimitedFeatures = new SendMessage(idChat3, EnumsInfo2.LIMITED_FEATURES.getText());
                    telegramBot.execute(messageLimitedFeatures);
                } else if (call_data2.equals("dogHandler")) {
                    SendMessage messageDogHandler = new SendMessage(idChat3, EnumsInfo2.DOG_HANDLER.getText());
                    telegramBot.execute(messageDogHandler);
                } else if (call_data2.equals("provenDogHandlers")) {
                    SendMessage messageProvenDogHandlers = new SendMessage(idChat3, EnumsInfo2.PROVEN_DOG_HANDLERS.getText());
                    telegramBot.execute(messageProvenDogHandlers);
                } else if (call_data2.equals("reasonsForRefusal")) {
                    SendMessage messageReasonsForRefusal = new SendMessage(idChat3, EnumsInfo2.REASONS_FOR_REFUSAL.getText());
                    telegramBot.execute(messageReasonsForRefusal);
                } else if (call_data2.equals("sendContact")) {
                    SendMessage messageSendContact = new SendMessage(idChat3, EnumsInfo.SEND_CONTACT.getText());
                    telegramBot.execute(messageSendContact);
                    String contactMessage = update.message().text();
                    if (contactMessage.isEmpty()) {
                        throw new RuntimeException();
                    } else {
                        addContactToUser(contactMessage, idChat3);
                        SendMessage dataRecordingMessage = new SendMessage(idChat3, "Данные сохранены");
                        telegramBot.execute(dataRecordingMessage);
                    }
                } else if (update.callbackQuery().data().equals("volunteer")) {
                    SendMessage messageVolunteer = new SendMessage(idChat3, EnumsInfo.VOLUNTEER.getText());
                    telegramBot.execute(messageVolunteer);
                }
            }

        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
    private void addContactToUser(String contactMessage, long idChat) {
        Contact contact = Parsers.parseContact(contactMessage);
        var user = usersService.findByChatId(idChat);
        user.setContact(contact);
        usersService.updateUser(user);
    }
}
