package dev.pro.shelter.service;

import dev.pro.shelter.model.Pet;
import dev.pro.shelter.repository.CatRepository;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements PetService {
    private final CatRepository catRepository;


    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
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
