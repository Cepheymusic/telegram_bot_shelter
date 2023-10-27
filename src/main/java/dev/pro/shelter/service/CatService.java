package dev.pro.shelter.service;

import dev.pro.shelter.model.Cat;


public interface CatService extends PetService{
    Cat createCat(Cat cat);
    Cat readCat(Long id);
    Cat updateCat(Long id, Cat cat);
    Cat deleteCat(Long id);
}
