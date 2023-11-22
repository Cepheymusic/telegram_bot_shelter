package dev.pro.shelter.service.impl;


import dev.pro.shelter.exception.DogNotFoundException;
import dev.pro.shelter.model.Dog;
import dev.pro.shelter.repository.DogRepository;
import dev.pro.shelter.service.DogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
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
    public Dog readDog(long id) {
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
    public Dog updateDog(Dog dog) {
        logger.info("Вызван метод update с данными: " + dog);
        if (dogRepository.findById(dog.getId()).isEmpty()) {
            throw new DogNotFoundException("Собакена нет");
        }
        Dog updateDog = dogRepository.save(dog);
        logger.info("Из метода update вернули" + dog);
        return updateDog;
    }

    @Override
    public Dog deleteDog(long id) {
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
