package dev.pro.shelter.service;

import dev.pro.shelter.model.Cat;


public interface CatService extends PetService{
    Cat createCat(Cat cat);
    Cat readCat(long id);
    Cat updateCat(Cat cat);
    Cat deleteCat(long id);
}
