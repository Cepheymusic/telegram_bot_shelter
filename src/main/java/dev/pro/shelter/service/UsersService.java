package dev.pro.shelter.service;

import dev.pro.shelter.model.Users;

public interface UsersService {
    boolean existsUserByChatId(Long chatId);
    Users createUser(Long chatId);
    Users findByChatId(Long chatId);
    Users updateUser(Users user);
    long findUserIdFromChatId(Long chatId);

    Users readUser(Long id);
}
