package dev.pro.shelter.service;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyboardMarkup {
    public InlineKeyboardMarkup markupInlineDog() {

        InlineKeyboardMarkup markupInlineDog = new InlineKeyboardMarkup();
        markupInlineDog.addRow(new InlineKeyboardButton("Рассказать о приюте").callbackData("infoDogShelter"),
                new InlineKeyboardButton("Расписание работы, адрес").callbackData("searchDogShelter"));
        markupInlineDog.addRow(new InlineKeyboardButton("Контактные данные охраны для оформления пропуска на машину").callbackData("securityData"));
        markupInlineDog.addRow(new InlineKeyboardButton("Рекомендации о технике безопасности на территории приюта").callbackData("safetyPrecautions"));
        markupInlineDog.addRow(new InlineKeyboardButton("Позвать волонтёра").callbackData("volunteer"),
                new InlineKeyboardButton("Отправить контактные данные").callbackData("sendContact"));
        markupInlineDog.addRow(new InlineKeyboardButton("Отправить отчёт").callbackData("sendDogReport"));
        return markupInlineDog;
    }

    public InlineKeyboardMarkup markupInlineCat() {
        InlineKeyboardMarkup markupInlineCat = new InlineKeyboardMarkup();
        markupInlineCat.addRow(new InlineKeyboardButton("Рассказать о приюте").callbackData("infoCatShelter"),
                new InlineKeyboardButton("Расписание работы, адрес").callbackData("searchDogShelter"));
        markupInlineCat.addRow(new InlineKeyboardButton("Контактные данные охраны для оформления пропуска на машину").callbackData("securityData"));
        markupInlineCat.addRow(new InlineKeyboardButton("Рекомендации о технике безопасности на территории приюта").callbackData("safetyPrecautions"));
        markupInlineCat.addRow(new InlineKeyboardButton("Позвать волонтёра").callbackData("volunteer"),
                new InlineKeyboardButton("Отправить контактные данные").callbackData("sendContact"));
        markupInlineCat.addRow(new InlineKeyboardButton("Отправить отчёт").callbackData("sendCatReport"));
        return markupInlineCat;
    }

    public InlineKeyboardMarkup markupInlineDogInfo() {
        InlineKeyboardMarkup markupInlineDogInfo = new InlineKeyboardMarkup(
                new InlineKeyboardButton("Правила знакомства с животным").callbackData("datingRules"));
        markupInlineDogInfo.addRow(new InlineKeyboardButton("Список документов, необходимых для того, чтобы взять животное из приюта").callbackData("listOfDocuments"));
        markupInlineDogInfo.addRow(new InlineKeyboardButton("Список рекомендаций по транспортировке животного").callbackData("transportation"));
        markupInlineDogInfo.addRow(new InlineKeyboardButton("Список рекомендаций по обустройству дома для маленького животного").callbackData("arrangingAPuppy"));
        markupInlineDogInfo.addRow(new InlineKeyboardButton("Список рекомендаций по обустройству дома для взрослого животного").callbackData("arrangementOfAnAdultAnimal"));
        markupInlineDogInfo.addRow(new InlineKeyboardButton("Список рекомендаций по обустройству дома для животного с ограниченными возможностями").callbackData("limitedFeatures"));
        markupInlineDogInfo.addRow(new InlineKeyboardButton("Причины, по которым могут отказать и не дать забрать животное из приюта.").callbackData("reasonsForRefusal"));
        markupInlineDogInfo.addRow(new InlineKeyboardButton("Принять и записать контактные данные для связи").callbackData("sendContact"));
        markupInlineDogInfo.addRow(new InlineKeyboardButton("Позвать волонтёра").callbackData("volunteer"));
        markupInlineDogInfo.addRow(new InlineKeyboardButton("Советы кинолога по первичному общению с собакой").callbackData("dogHandler"));
        markupInlineDogInfo.addRow(new InlineKeyboardButton("Рекомендации по проверенным кинологам для дальнейшего обращения к ним").callbackData("provenDogHandlers"));
        return markupInlineDogInfo;
    }

    public InlineKeyboardMarkup markupInlineCatInfo() {

        InlineKeyboardMarkup markupInlineCatInfo = new InlineKeyboardMarkup(
                new InlineKeyboardButton("Правила знакомства с животным").callbackData("datingRules"));
        markupInlineCatInfo.addRow(new InlineKeyboardButton("Список документов, необходимых для того, чтобы взять животное из приюта").callbackData("listOfDocuments"));
        markupInlineCatInfo.addRow(new InlineKeyboardButton("Список рекомендаций по транспортировке животного").callbackData("transportation"));
        markupInlineCatInfo.addRow(new InlineKeyboardButton("Список рекомендаций по обустройству дома для маленького животного").callbackData("arrangingAPuppy"));
        markupInlineCatInfo.addRow(new InlineKeyboardButton("Список рекомендаций по обустройству дома для взрослого животного").callbackData("arrangementOfAnAdultAnimal"));
        markupInlineCatInfo.addRow(new InlineKeyboardButton("Список рекомендаций по обустройству дома для животного с ограниченными возможностями").callbackData("limitedFeatures"));
        markupInlineCatInfo.addRow(new InlineKeyboardButton("Причины, по которым могут отказать и не дать забрать животное из приюта.").callbackData("reasonsForRefusal"));
        markupInlineCatInfo.addRow(new InlineKeyboardButton("Принять и записать контактные данные для связи").callbackData("sendContact"));
        markupInlineCatInfo.addRow(new InlineKeyboardButton("Позвать волонтёра").callbackData("volunteer"));
        return markupInlineCatInfo;
    }

}
