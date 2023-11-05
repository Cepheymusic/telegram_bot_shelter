package dev.pro.shelter.service;


import dev.pro.shelter.model.Dog;

public interface DogService{
    Dog createDog(Dog dog);
    Dog readDog(long id);
    Dog updateDog(Dog dog);
    Dog deleteDog(long id);

}
