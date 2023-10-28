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
import dev.pro.shelter.model.Users;
import dev.pro.shelter.service.impl.UsersServiceImpl;
import dev.pro.shelter.tools.Parsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        try {
            updates.forEach(update -> {
                logger.info("Processing update: {}", update);
                String message = update.message().text();
                if (message == null) {
                    throw new dev.pro.shelter.Exception.MessageNotFound("Вы отправили пустое сообщение");
                } else if (message.equals("/start")) {
                    long idChat = update.message().chat().id();
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup(
                            new InlineKeyboardButton("Приют для собак").callbackData("dogShelter"),
                            new InlineKeyboardButton("Приют для кошек").callbackData("catShelter"));
                    if (userService.existsUserByChatId(idChat)) {
                        SendMessage messageForUser1 = new SendMessage(idChat, "Приветствуем старого знакомого. Выберите приют:")
                                .replyMarkup(markupInline);
                        telegramBot.execute(messageForUser1);
                    } else {
                        SendMessage messageForUser2 = new SendMessage(idChat, "Приветствуем нового гостя. Вы можете выбрать себе друга из приюта:")
                                .replyMarkup(markupInline);
                        userService.createUser(update.message().chat().id());
                        telegramBot.execute(messageForUser2);
                    }
                    if (update.callbackQuery().data().equals("dogShelter")) {
                        InlineKeyboardMarkup markupInline2 = new InlineKeyboardMarkup(
                                new InlineKeyboardButton("Рассказать о приюте").callbackData("infoDogShelter"),
                                new InlineKeyboardButton("Расписание работы, адрес и схема проезда").callbackData("searchDogShelter"),
                                new InlineKeyboardButton("Контактные данные охраны для оформления пропуска на машину").callbackData("securityData"),
                                new InlineKeyboardButton("Рекомендации о технике безопасности на территории приюта").callbackData("safetyPrecautions"),
                                new InlineKeyboardButton("Отправить контактные данные").callbackData("sendContact"),
                                new InlineKeyboardButton("Позвать волонтёра").callbackData("volunteer"));
                        if (update.callbackQuery().data().equals("infoDogShelter")) {
                            SendMessage messageShelterInfo = new SendMessage(idChat, EnumsInfo.INFO_DOG_SHELTER.getText());
                            telegramBot.execute(messageShelterInfo);
                            InlineKeyboardMarkup markupInline3 = new InlineKeyboardMarkup(
                                    new InlineKeyboardButton("Правила знакомства с животным").callbackData("datingRules"),
                                    new InlineKeyboardButton("Список документов, необходимых для того, чтобы взять животное из приюта").callbackData("listOfDocuments"),
                                    new InlineKeyboardButton("Список рекомендаций по транспортировке животного").callbackData("transportation"),
                                    new InlineKeyboardButton("Список рекомендаций по обустройству дома для щенка").callbackData("arrangingAPuppy"),
                                    new InlineKeyboardButton("Список рекомендаций по обустройству дома для взрослого животного").callbackData("arrangementOfAnAdultAnimal"),
                                    new InlineKeyboardButton("Список рекомендаций по обустройству дома для животного с ограниченными возможностями").callbackData("limitedFeatures"),
                                    new InlineKeyboardButton("Советы кинолога по первичному общению с собакой").callbackData("dogHandler"),
                                    new InlineKeyboardButton("Рекомендации по проверенным кинологам для дальнейшего обращения к ним").callbackData("provenDogHandlers"),
                                    new InlineKeyboardButton("Причины, по которым могут отказать и не дать забрать собаку из приюта.").callbackData("reasonsForRefusal"),
                                    new InlineKeyboardButton("Принять и записать контактные данные для связи").callbackData("sendContact"),
                                    new InlineKeyboardButton("Позвать волонтёра").callbackData("volunteer"));
                            if (update.callbackQuery().data().equals("datingRules")) {
                                SendMessage messageDatingRules = new SendMessage(idChat, EnumsInfo2.DATING_RULES.getText());
                                telegramBot.execute(messageDatingRules);
                            } else if (update.callbackQuery().data().equals("listOfDocuments")) {
                                SendMessage messageListOfDocuments = new SendMessage(idChat, EnumsInfo2.LIST_OF_DOCUMENTS.getText());
                                telegramBot.execute(messageListOfDocuments);
                            } else if (update.callbackQuery().data().equals("transportation")) {
                                SendMessage messageTransportation = new SendMessage(idChat, EnumsInfo2.TRANSPORTATION.getText());
                                telegramBot.execute(messageTransportation);
                            } else if (update.callbackQuery().data().equals("arrangingAPuppy")) {
                                SendMessage messageArrangingAPuppy = new SendMessage(idChat, EnumsInfo2.ARRANGING_A_PUPPY.getText());
                                telegramBot.execute(messageArrangingAPuppy);
                            } else if (update.callbackQuery().data().equals("arrangementOfAnAdultAnimal")) {
                                SendMessage messageArrangementOfAnAdultAnimal = new SendMessage(idChat, EnumsInfo2.ARRANGEMENT_OF_AN_ADULT_ANIMAL.getText());
                                telegramBot.execute(messageArrangementOfAnAdultAnimal);
                            } else if (update.callbackQuery().data().equals("limitedFeatures")) {
                                SendMessage messageLimitedFeatures = new SendMessage(idChat, EnumsInfo2.LIMITED_FEATURES.getText());
                                telegramBot.execute(messageLimitedFeatures);
                            } else if (update.callbackQuery().data().equals("dogHandler")) {
                                SendMessage messageDogHandler = new SendMessage(idChat, EnumsInfo2.DOG_HANDLER.getText());
                                telegramBot.execute(messageDogHandler);
                            } else if (update.callbackQuery().data().equals("provenDogHandlers")) {
                                SendMessage messageProvenDogHandlers = new SendMessage(idChat, EnumsInfo2.PROVEN_DOG_HANDLERS.getText());
                                telegramBot.execute(messageProvenDogHandlers);
                            } else if (update.callbackQuery().data().equals("reasonsForRefusal")) {
                                SendMessage messageReasonsForRefusal = new SendMessage(idChat, EnumsInfo2.REASONS_FOR_REFUSAL.getText());
                                telegramBot.execute(messageReasonsForRefusal);
                            } else if (update.callbackQuery().data().equals("reasonsForRefusal")) {
                                SendMessage messageReasonsForRefusal = new SendMessage(idChat, EnumsInfo2.REASONS_FOR_REFUSAL.getText());
                                telegramBot.execute(messageReasonsForRefusal);
                            } else if (update.callbackQuery().data().equals("sendContact")) {
                                SendMessage messageSendContact = new SendMessage(idChat, EnumsInfo.SEND_CONTACT.getText());
                                telegramBot.execute(messageSendContact);
                                String contactMessage = update.message().text();
                                if (contactMessage.isEmpty()) {
                                    throw new RuntimeException();
                                } else {
                                    addContactToUser(update, idChat);
//                              Contact contact = Parsers.parseContact(update.message().text());
//                              contactRepository.save(contact);
                                    SendMessage dataRecordingMessage = new SendMessage(idChat, "Данные сохранены");
                                    telegramBot.execute(dataRecordingMessage);
                                }
                            } else if (update.callbackQuery().data().equals("volunteer")) {
                                SendMessage messageVolunteer = new SendMessage(idChat, EnumsInfo.VOLUNTEER.getText());
                                telegramBot.execute(messageVolunteer);
                            }
                        } else if (update.callbackQuery().data().equals("searchDogShelter")) {
                            SendMessage messageSearchDogShelter = new SendMessage(idChat, EnumsInfo.SEARCH_DOG_SHELTER.getText());
                            telegramBot.execute(messageSearchDogShelter);
                        } else if (update.callbackQuery().data().equals("securityData")) {
                            SendMessage messageSecurityData = new SendMessage(idChat, EnumsInfo.SECURITY_DATA.getText());
                            telegramBot.execute(messageSecurityData);
                        } else if (update.callbackQuery().data().equals("safetyPrecautions")) {
                            SendMessage messageSafetyPrecautions = new SendMessage(idChat, EnumsInfo.SAFETY_PRECAUTIONS.getText());
                            telegramBot.execute(messageSafetyPrecautions);
                        } else if (update.callbackQuery().data().equals("sendContact")) {
                            SendMessage messageSendContact = new SendMessage(idChat, EnumsInfo.SEND_CONTACT.getText());
                            telegramBot.execute(messageSendContact);
                            String contactMessage = update.message().text();
                            if (contactMessage.isEmpty()) {
                                throw new RuntimeException();
                            } else {
                                addContactToUser(update, idChat);
//                            Contact contact = Parsers.parseContact(update.message().text());
//                            contactRepository.save(contact);
                                SendMessage dataRecordingMessage = new SendMessage(idChat, "Данные сохранены");
                                telegramBot.execute(dataRecordingMessage);
                            }
                        } else if (update.callbackQuery().data().equals("volunteer")) {
                            SendMessage messageVolunteer = new SendMessage(idChat, EnumsInfo.VOLUNTEER.getText());
                            telegramBot.execute(messageVolunteer);
                        }
                    }
                }
            });
        }catch (NullPointerException e){
            throw new RuntimeException(e);}
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void addContactToUser(Update update, long idChat) {
        Contact contact = Parsers.parseContact(update.message().text());
        var user = userService.findByChatId(idChat);
        user.setContact(contact);
        userService.updateUser(user);
    }
}
