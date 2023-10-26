package dev.pro.shelter.service.impl;

import dev.pro.shelter.model.Users;
import dev.pro.shelter.repository.UsersRepository;
import dev.pro.shelter.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository repository;

    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public Users readByChatId(Long chatId) {
        return repository.findByChatId(chatId);
    }
}
