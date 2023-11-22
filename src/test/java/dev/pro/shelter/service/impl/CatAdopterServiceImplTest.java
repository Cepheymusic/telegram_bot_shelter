package dev.pro.shelter.service.impl;

import dev.pro.shelter.exception.UsersException;
import dev.pro.shelter.model.Cat;
import dev.pro.shelter.model.CatAdopter;
import dev.pro.shelter.model.Contact;
import dev.pro.shelter.model.Users;
import dev.pro.shelter.repository.CatAdopterRepository;
import dev.pro.shelter.service.CatService;
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
class CatAdopterServiceImplTest {
    @InjectMocks
    CatAdopterServiceImpl underTest;
    @Mock
    private CatAdopterRepository repository;
    @Mock
    private UsersService usersService;
    @Mock
    private CatService catService;

    @BeforeEach
    void beforeEach() {
        underTest = new CatAdopterServiceImpl(repository, usersService, catService);
    }

    Cat cat = new Cat(1L, "Cat", 10, "test", true, new CatAdopter());
    Contact contact = new Contact("Serzh", "Serzhov", "+798788880000", "af@gmai.com");
    Users user = new Users(1L, 123L, contact);
    CatAdopter catAdopter = new CatAdopter(1L, user,
            "off streat", LocalDate.now());
    @Test
    void registrationCatAdopter_registrationAndReturnCatAdopter() {
        when(repository.save(any())).thenReturn(catAdopter);
        when(usersService.readUser(1L)).thenReturn(user);
        when(catService.updateCat(cat)).thenReturn(cat);
        when(catService.readCat(1L)).thenReturn(cat);
        CatAdopter result = underTest.registrationCatAdopter(1L, 1L,
                "off streat");
        assertEquals(catAdopter, result);
    }

    @Test
    void readCatAdopter_readAndReturnCatAdopter() {
        when(repository.findById(1L)).thenReturn(Optional.of(catAdopter));
        CatAdopter result = underTest.readCatAdopter(1L);
        assertEquals(catAdopter, result);
    }

    @Test
    void updateCatAdopter_catAdopterWithoutInDb_returnUsersException() {
        when(repository.findByUsersId(1L)).thenReturn(Optional.empty());
        UsersException ex = assertThrows(UsersException.class,
                () -> underTest.updateCatAdopter(1L));
        assertEquals("Желающего забрать кота человека с таким id нет", ex.getMessage());
    }
    @Test
    void updateCatAdopter_catAdopterWithInDb_updateAndReturnCatAdopter() {
        when(repository.findByUsersId(1L)).thenReturn(Optional.of(catAdopter));
        CatAdopter result = underTest.updateCatAdopter(1L);
        assertEquals(catAdopter, result);
    }

    @Test
    void deleteCatAdopter_deleteAndReturnCatAdopter() {
        when(repository.findById(1L)).thenReturn(Optional.of(catAdopter));
        CatAdopter result = underTest.deleteCatAdopter(1L);
        assertEquals(catAdopter, result);
    }

    @Test
    void readCatAdopterByUserId_catAdopterInDb_readByUserIdAndReturnCatAdopter() {
        when(repository.findByUsersId(1L)).thenReturn(Optional.of(catAdopter));
        CatAdopter result = underTest.readCatAdopterByUserId(1L);
        assertEquals(catAdopter, result);
    }
    @Test
    void readCatAdopterByUserId_catAdopterIsNotDb_returnUsersException() {
        when(repository.findByUsersId(1L)).thenReturn(Optional.empty());
        UsersException ex = assertThrows(UsersException.class,
                () -> underTest.readCatAdopterByUserId(1L));
        assertEquals("Желающего забрать кота человека с таким id нет", ex.getMessage());
    }

    @Test
    void readCatAdopterIdFromChatId_readAndReturnCatAdopterId() {
        when(usersService.findUserIdFromChatId(123L)).thenReturn(1L);
        when(repository.findByUsersId(1L)).thenReturn(Optional.of(catAdopter));
        Long result = underTest.readCatAdopterIdFromChatId(123L);
        assertEquals(1L, result);
    }

    @Test
    void existsCatAdopterByChatId_returnTrue() {
        when(usersService.findUserIdFromChatId(123L)).thenReturn(1L);
        when(repository.existsById(1L)).thenReturn(true);
        Boolean result = underTest.existsCatAdopterByChatId(123L);
        assertTrue(true, String.valueOf(result));
    }
}