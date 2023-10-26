package dev.pro.shelter.service;

import dev.pro.shelter.model.Users;

public interface UsersService {
    Users readByChatId(Long chatId);
}
