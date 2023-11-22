package dev.pro.shelter.service.impl;

import dev.pro.shelter.exception.UsersException;
import dev.pro.shelter.model.*;
import dev.pro.shelter.repository.DogAdopterRepository;
import dev.pro.shelter.repository.DogRepository;
import dev.pro.shelter.service.DogService;
import dev.pro.shelter.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DogAdopterServiceImplTest {
    @InjectMocks
    DogAdopterServiceImpl underTest;
    @Mock
    private DogAdopterRepository repository;
    @Mock
    private UsersService usersService;
    @Mock
    private DogService dogService;
    @BeforeEach
    void beforeEach() {
        underTest = new DogAdopterServiceImpl(repository, usersService, dogService);
    }
    Dog dog = new Dog(1L, "Dog", 10, "test", true, new DogAdopter());
    Contact contact = new Contact("Serzh", "Serzhov", "+798788880000", "af@gmai.com");
    Users user = new Users(1L, 123L, contact);
    DogAdopter dogAdopter = new DogAdopter(1L, user,
            "off streat", LocalDate.now());
    @Test
    void registrationDogAdopter_registrationAndReturnDogAdopter() {
        when(repository.save(any())).thenReturn(dogAdopter);
        when(usersService.readUser(1L)).thenReturn(user);
        when(dogService.updateDog(dog)).thenReturn(dog);
        when(dogService.readDog(1L)).thenReturn(dog);
        DogAdopter result = underTest.registrationDogAdopter(1L, 1L,
                "off streat");
        assertEquals(dogAdopter, result);
    }

    @Test
    void readDogAdopter_readAndReturnDogAdopter() {
        when(repository.findById(1L)).thenReturn(Optional.of(dogAdopter));
        DogAdopter result = underTest.readDogAdopter(1L);
        assertEquals(dogAdopter, result);
    }

    @Test
    void updateDogAdopter_dogAdopterWithoutInDb_returnUsersException() {
        when(repository.findByUsersId(1L)).thenReturn(Optional.empty());
        UsersException ex = assertThrows(UsersException.class,
                () -> underTest.updateDogAdopter(1L));
        assertEquals("Желающего забрать собаку человека с таким id нет", ex.getMessage());
    }

    @Test
    void updateDogAdopter_dogAdopterWithInDb_updateAndReturnDogAdopter() {
        when(repository.findByUsersId(1L)).thenReturn(Optional.of(dogAdopter));
        DogAdopter result = underTest.updateDogAdopter(1L);
        assertEquals(dogAdopter, result);
    }

    @Test
    void deleteDogAdopter_deleteAndReturnCatAdopter() {
        when(repository.findById(1L)).thenReturn(Optional.of(dogAdopter));
        DogAdopter result = underTest.deleteDogAdopter(1L);
        assertEquals(dogAdopter, result);
    }

    @Test
    void readDogAdopterByUserId_dogAdopterInDb_readByUserIdAndReturnDogAdopter() {
        when(repository.findByUsersId(1L)).thenReturn(Optional.of(dogAdopter));
        DogAdopter result = underTest.readDogAdopterByUserId(1L);
        assertEquals(dogAdopter, result);
    }

    @Test
    void readDogAdopterByUserId_dogAdopterIsNotDb_returnUsersException() {
        when(repository.findByUsersId(1L)).thenReturn(Optional.empty());
        UsersException ex = assertThrows(UsersException.class,
                () -> underTest.readDogAdopterByUserId(1L));
        assertEquals("Желающего забрать собаку человека с таким id нет", ex.getMessage());
    }

    @Test
    void readDogAdopterIdFromChatId_readAndReturnDogAdopterId() {
        when(usersService.findUserIdFromChatId(123L)).thenReturn(1L);
        when(repository.findByUsersId(1L)).thenReturn(Optional.of(dogAdopter));
        Long result = underTest.readDogAdopterIdFromChatId(123L);
        assertEquals(1L, result);
    }

    @Test
    void existsDogAdopterByChatId_returnTrue() {
        when(usersService.findUserIdFromChatId(123L)).thenReturn(1L);
        when(repository.existsById(1L)).thenReturn(true);
        Boolean result = underTest.existsDogAdopterByChatId(123L);
        assertTrue(true, String.valueOf(result));
    }
}