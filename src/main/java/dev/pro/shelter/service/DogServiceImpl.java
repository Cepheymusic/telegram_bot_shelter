package dev.pro.shelter.service;



import dev.pro.shelter.Exception.CatNotFoundException;
import dev.pro.shelter.Exception.DogNotFoundException;
import dev.pro.shelter.model.Cat;
import dev.pro.shelter.model.Dog;
import dev.pro.shelter.repository.DogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;


public class DogServiceImpl implements DogService {
    private final DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    Logger logger = LoggerFactory.getLogger(DogServiceImpl.class);

    @Override
    public Dog createDog(Dog dog) {
        logger.info("Вызван метод create с данными" + dog);
        Dog savedDog = dogRepository.save(dog);
        logger.info("Из метода create вернули" + dog);
        return savedDog;

    }

    @Override
    public Dog readDog(Long id) {
        logger.info("Вызван метод read с данными" + id);
        Optional<Dog> searchDog = dogRepository.findById(id);
        if (searchDog.isEmpty()) {
            throw new DogNotFoundException("Собакена нет");
        }
        Dog readDog = searchDog.get();
        logger.info("Из метода read вернули" + searchDog.get());
        return readDog;
    }

    @Override
    public Dog updateDog(Long id, Dog dog) {
        logger.info("Вызван метод update с данными: {],{}" + id, dog);
        if (dogRepository.findById(id).isEmpty()) {
            throw new DogNotFoundException("Собакена нет");
        }
        Dog updateDog = dogRepository.save(dog);
        logger.info("Из метода update вернули" + dog);
        return updateDog;
    }

    @Override
    public Dog deleteDog(Long id) {
        logger.info("Вызван метод delete с данными" + id);
        Optional<Dog> searchCat = dogRepository.findById(id);
        if (searchCat.isEmpty()) {
            throw new DogNotFoundException("Собакена нет");
        }
        dogRepository.deleteById(id);
        Dog deleteDog = searchCat.get();
        logger.info("Из метода delete вернули" + deleteDog);
        return deleteDog;
    }
}
