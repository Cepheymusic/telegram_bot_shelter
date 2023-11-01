package dev.pro.shelter.service;

public interface TelegramBotService {
    void addContactToUser(String contactMessage, long idChat);
}
