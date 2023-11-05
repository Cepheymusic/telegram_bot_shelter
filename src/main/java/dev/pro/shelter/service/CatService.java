package dev.pro.shelter.service;

import dev.pro.shelter.model.Cat;
import dev.pro.shelter.model.CatAdopter;

import java.util.List;


public interface CatService{
    Cat createCat(Cat cat);
    Cat readCat(long id);
    Cat updateCat(Cat cat);
    Cat deleteCat(long id);
}
