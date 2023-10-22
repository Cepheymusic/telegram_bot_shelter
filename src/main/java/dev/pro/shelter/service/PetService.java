package dev.pro.shelter.service;

import dev.pro.shelter.model.Pet;

public interface PetService {
    Pet createPet(Pet pet);

    Pet updatePet(Long id);

    Pet deletePet(Long id);

    Pet readPet(Long id);

}
