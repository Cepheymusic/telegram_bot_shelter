package dev.pro.shelter.service.impl;

import dev.pro.shelter.exception.DogNotFoundException;
import dev.pro.shelter.exception.UsersException;
import dev.pro.shelter.model.*;
import dev.pro.shelter.repository.DogAdopterRepository;
import dev.pro.shelter.service.DogAdopterService;
import dev.pro.shelter.service.DogService;
import dev.pro.shelter.service.UsersService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DogAdopterServiceImpl implements DogAdopterService {

    private final DogAdopterRepository repository;
    private final UsersService usersService;
    private final DogService catService;

    public DogAdopterServiceImpl(DogAdopterRepository repository, UsersService usersService, DogService catService) {
        this.repository = repository;
        this.usersService = usersService;
        this.catService = catService;
    }

    @Override
    public DogAdopter registrationDogAdopter(long idUser, long idDog, String address) {
        DogAdopter dogAdopter = new DogAdopter();
        Users user = usersService.readUser(idUser);
        dogAdopter.setAddress(address);
        dogAdopter.setUsers(user);
        dogAdopter.setDateStartProbation(LocalDate.now());
        var adopter = repository.save(dogAdopter);
        Dog adoptedDog = catService.readDog(idDog);
        adoptedDog.setDogAdopter(adopter);
        catService.updateDog(adoptedDog);
        return adopter;
    }

    @Override
    public DogAdopter readDogAdopter(long id) {

        return repository.findById(id).orElseThrow(() -> new UsersException("Желающего забрать собаку человека с таким id нет"));
    }

    @Override
    public DogAdopter updateDogAdopter(long idUser) {
        return repository.findByUserId(idUser).orElseThrow(()->new UsersException("Желающего забрать собаку человека " +
                "с таким id нет"));
    }

    @Override
    public DogAdopter deleteDogAdopter(long id) {
        repository.deleteById(id);
        return readDogAdopter(id);
    }

    @Override
    public LocalDate readStartDate(long id) {
        return readDogAdopter(id).getDateStartProbation();
    }
    @Override
    public LocalDate readStartDateFromChatId(long chatId) {
        return readDogAdopter(chatId).getDateStartProbation();
    }

    @Override
    public DogAdopter readDogAdopterByUserId(long userId) {
        Optional<DogAdopter> adopter = repository.findByUserId(userId);
        if (adopter.isEmpty()) {
            throw new DogNotFoundException("Желающего забрать собаку человека с таким id нет");
        }
        return adopter.get();
    }

    @Override
    public Long readDogAdopterIdFromChatId(long chatId){
        return readDogAdopterFromChatId(chatId).getIdDogAdopter();
    }
    @Override
    public boolean existsDogAdopterByChatId(Long chatId) {
        long userId = usersService.findUserIdFromChatId(chatId);
        return repository.existsById(userId);
    }

    private DogAdopter readDogAdopterFromChatId(long chatId){
        long userId = usersService.findUserIdFromChatId(chatId);
        return readDogAdopterByUserId(userId);
    }
}
