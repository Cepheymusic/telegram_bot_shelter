package dev.pro.shelter.service.impl;

import dev.pro.shelter.exception.CatNotFoundException;
import dev.pro.shelter.exception.UsersException;
import dev.pro.shelter.model.Cat;
import dev.pro.shelter.model.CatAdopter;
import dev.pro.shelter.model.Users;
import dev.pro.shelter.repository.CatAdopterRepository;
import dev.pro.shelter.service.CatAdopterService;
import dev.pro.shelter.service.CatService;
import dev.pro.shelter.service.UsersService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CatAdopterServiceImpl implements CatAdopterService {
    private final CatAdopterRepository repository;
    private final UsersService usersService;
    private final CatService catService;

    public CatAdopterServiceImpl(CatAdopterRepository repository, UsersService usersService, CatService catService) {
        this.repository = repository;
        this.usersService = usersService;
        this.catService = catService;
    }

    @Override
    public CatAdopter registrationCatAdopter(long idUser, long idCat, String address) {
        CatAdopter catAdopter = new CatAdopter();
        Users user = usersService.readUser(idUser);
        catAdopter.setAddress(address);
        catAdopter.setUsers(user);
        catAdopter.setDateStartProbation(LocalDate.now());
        var adopter = repository.save(catAdopter);
        Cat adoptedCat = catService.readCat(idCat);
        adoptedCat.setCatAdopter(adopter);
        catService.updateCat(adoptedCat);
        return adopter;
    }

    @Override
    public CatAdopter readCatAdopter(long id) {
        return repository.findById(id).orElseThrow(()->new UsersException("Желающего забрать кота человека с таким id нет"));
    }

    @Override
    public CatAdopter updateCatAdopter(long idUser) {
        return repository.findByUsersId(idUser).orElseThrow(()->new UsersException("Желающего забрать кота человека " +
                "с таким id нет"));
    }

    @Override
    public CatAdopter deleteCatAdopter(long id) {
        repository.deleteById(id);
        return readCatAdopter(id);
    }

    @Override
    public LocalDate readStartDate(long id) {
        return readCatAdopter(id).getDateStartProbation();
    }

    @Override
    public LocalDate readStartDateFromChatId(long chatId) {
        return readCatAdopterFromChatId(chatId).getDateStartProbation();
    }

    @Override
    public CatAdopter readCatAdopterByUserId(long userId) {
        Optional<CatAdopter> adopter = repository.findByUsersId(userId);
        if (adopter.isEmpty()) {
            throw new UsersException("Желающего забрать кота человека с таким id нет");
        }
        return adopter.get();
    }

    @Override
    public Long readCatAdopterIdFromChatId(long chatId){
        return readCatAdopterFromChatId(chatId).getIdCatAdopter();
    }
    @Override
    public boolean existsCatAdopterByChatId(Long chatId) {
        long userId = usersService.findUserIdFromChatId(chatId);
        return repository.existsById(userId);
    }

    private CatAdopter readCatAdopterFromChatId(long chatId){
        long userId = usersService.findUserIdFromChatId(chatId);
        return readCatAdopterByUserId(userId);
    }
}
