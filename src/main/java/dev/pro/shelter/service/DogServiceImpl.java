package dev.pro.shelter.service;

import dev.pro.shelter.model.Pet;
import dev.pro.shelter.repository.DogRepository;

public class DogServiceImpl implements PetService {
    private final DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public Pet createPet(Pet pet) {
        return null;
    }

    @Override
    public Pet updatePet(Long id) {
        return null;
    }

    @Override
    public Pet deletePet(Long id) {
        return null;
    }

    @Override
    public Pet readPet(Long id) {
        return null;
    }
}
