package dev.pro.shelter.service.impl;

import dev.pro.shelter.exception.UsersException;
import dev.pro.shelter.model.Users;
import dev.pro.shelter.repository.UsersRepository;
import dev.pro.shelter.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    private final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);
    private final UsersRepository repository;

    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsUserByChatId(Long chatId) {
        return repository.existsByChatId(chatId);
    }

    @Override
    public Users createUser(Long chatId) {
        logger.info("The Create method was called with data {}", chatId);
        Users createUsers = new Users();
        createUsers.setChatId(chatId);
        Users newUser = repository.save(createUsers);
        logger.info("Returned from the Create method {}", newUser);
        return newUser;
    }

    @Override
    public Users findByChatId(Long chatId) {
        logger.info("The FindByChatId method was called with data {}", chatId);
        Optional<Users> user = repository.findByChatId(chatId);
        if (user.isEmpty()) {
            throw new UsersException("failure identification");
        }
        Users findUser = user.get();
        logger.info("Returned from the FindByChatId method {}", findUser);
        return findUser;
    }

    @Override
    public Users updateUser(Users user){
        logger.info("The Update method was called with data {}", user);
        if (repository.findById(user.getId()).isEmpty()) {
            throw new UsersException("failure identification");
        }
        Users updatedUser = repository.save(user);
        logger.info("Returned from the Update method {}", updatedUser);
        return updatedUser;
    }
}