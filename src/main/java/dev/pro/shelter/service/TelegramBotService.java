package dev.pro.shelter.service;

public interface TelegramBotService {
    void addContactToUser(String contactMessage, long idChat);
    void addReportToDB(long idChat, String textMsg);
    void sendMessageFromReportManagement(long idChat, String text);
}
