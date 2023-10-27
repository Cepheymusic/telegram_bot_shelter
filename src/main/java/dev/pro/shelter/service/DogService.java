package dev.pro.shelter.service;


import dev.pro.shelter.model.Dog;

public interface DogService {
    Dog createDog(Dog dog);
    Dog readDog(Long id);
    Dog updateDog(Long id, Dog dog);
    Dog deleteDog(Long id);

}
