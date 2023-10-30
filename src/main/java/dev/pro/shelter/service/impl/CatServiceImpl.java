package dev.pro.shelter.service.impl;

import dev.pro.shelter.Exception.CatNotFoundException;
import dev.pro.shelter.model.Cat;

import dev.pro.shelter.repository.CatRepository;
import dev.pro.shelter.service.CatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CatServiceImpl implements CatService {
    private final CatRepository catRepository;


    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(CatServiceImpl.class);

    @Override
    public Cat createCat(Cat cat) {
        logger.info("Вызван метод create с данными" + cat);
        Cat savedCat = catRepository.save(cat);
        logger.info("Из метода create вернули" + cat);
        return savedCat;
    }

    @Override
    public Cat readCat(long id) {
        logger.info("Вызван метод read с данными" + id);
        Optional<Cat> searchCat = catRepository.findById(id);
        if (searchCat.isEmpty()) {
            throw new CatNotFoundException("Котэ нет");
        }
        Cat readCat = searchCat.get();
        logger.info("Из метода read вернули" + searchCat.get());
        return readCat;
    }

    @Override
    public Cat updateCat(Cat cat) {
        logger.info("Вызван метод update с данными: " + cat);
        if (catRepository.findById(cat.getId()).isEmpty()) {
            throw new CatNotFoundException("Котэ нет");
        }
        Cat updateCat = catRepository.save(cat);
        logger.info("Из метода update вернули" + cat);
        return updateCat;
    }

    @Override
    public Cat deleteCat(long id) {
        logger.info("Вызван метод delete с данными" + id);
        Optional<Cat> searchCat = catRepository.findById(id);
        if (searchCat.isEmpty()) {
            throw new CatNotFoundException("Котэ нет");
        }
        catRepository.deleteById(id);
        Cat deleteCat = searchCat.get();
        logger.info("Из метода delete вернули" + deleteCat);
        return deleteCat;
    }
}
