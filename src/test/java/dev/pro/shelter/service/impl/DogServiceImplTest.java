package dev.pro.shelter.service.impl;

import dev.pro.shelter.exception.DogNotFoundException;
import dev.pro.shelter.model.Dog;
import dev.pro.shelter.repository.DogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class DogServiceImplTest {
    @InjectMocks
    DogServiceImpl underTest;
    @Mock
    private DogRepository repository;
    static Dog dog1 = new Dog(1L, "Caty", null, 5, "mainkun", true,"free");

    @BeforeEach
    void beforeEach() {
        underTest = new DogServiceImpl(repository);
    }

    @Test
    void createDog_saveDogInRepositoryAndReturn() {
        when(repository.save(dog1)).thenReturn(dog1);
        Dog result = underTest.createDog(dog1);
        assertEquals(dog1, result);
    }

    @Test
    void readDog_dogInRepository_findDogAndReturn() {
        when(repository.findById(1L)).thenReturn(Optional.of(dog1));
        Dog result = underTest.readDog(1L);
        assertEquals(dog1, result);
    }
    @Test
    void readDog_DogIsNotRepository_returnDogNotFoundException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        DogNotFoundException ex = assertThrows(DogNotFoundException.class,
                () -> underTest.readDog(1L));
        assertEquals("Собакена нет", ex.getMessage());
    }

    @Test
    void updateDog_updateAndReturnDOg() {
        when(repository.findById(1L)).thenReturn(Optional.of(dog1));
        when(repository.save(dog1)).thenReturn(dog1);
        Dog result = underTest.updateDog(dog1);
        assertEquals(dog1, result);
    }
    @Test
    void updateDog_dogIsNotRepository_returnDogNotFoundException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        DogNotFoundException ex = assertThrows(DogNotFoundException.class,
                () -> underTest.updateDog(dog1));
        assertEquals("Собакена нет", ex.getMessage());
    }
    @Test
    void deleteDog_dogIsNotRepository_returnDogNotFoundException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        DogNotFoundException ex = assertThrows(DogNotFoundException.class,
                () -> underTest.deleteDog(1L));
        assertEquals("Собакена нет", ex.getMessage());
    }

}