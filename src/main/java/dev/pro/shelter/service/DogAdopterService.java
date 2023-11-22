package dev.pro.shelter.service;

import dev.pro.shelter.model.DogAdopter;

import java.time.LocalDate;

public interface DogAdopterService {
    DogAdopter registrationDogAdopter(long idUser, long idDog, String address);

    DogAdopter readDogAdopter(long id);

    DogAdopter updateDogAdopter(long idUser);

    DogAdopter deleteDogAdopter(long id);
    LocalDate readStartDate(long id);

    LocalDate readStartDateFromChatId(long chatId);

    DogAdopter readDogAdopterByUserId(long userId);

    Long readDogAdopterIdFromChatId(long chatId);

    boolean existsDogAdopterByChatId(Long chatId);
}
