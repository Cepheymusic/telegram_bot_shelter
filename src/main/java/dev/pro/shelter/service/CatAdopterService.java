package dev.pro.shelter.service;

import dev.pro.shelter.model.CatAdopter;

import java.time.LocalDate;

public interface CatAdopterService {
    CatAdopter registrationCatAdopter(long idUser, long idCat, String address);

    CatAdopter readCatAdopter(long id);

    CatAdopter updateCatAdopter(long idUser, CatAdopter catAdopter);

    CatAdopter deleteCatAdopter(long id);
    LocalDate readStartDate(long id);
    LocalDate readStartDateFromChatId(long userId);
    CatAdopter readCatAdopterByUserId(long userId);

    Long readCatAdopterIdFromChatId(long chatId);

    boolean existsCatAdopterByChatId(Long chatId);
}
