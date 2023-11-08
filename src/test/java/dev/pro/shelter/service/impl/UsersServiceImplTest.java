package dev.pro.shelter.service.impl;

import dev.pro.shelter.exception.UsersException;
import dev.pro.shelter.model.Contact;
import dev.pro.shelter.model.Users;
import dev.pro.shelter.repository.UsersRepository;
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
class UsersServiceImplTest {
    @InjectMocks
    UsersServiceImpl underTest;
    static Contact contact1 = new Contact("Sergey", "Sergeev", "79878279006", "a@gmail.com");
    static Users user1 = new Users(null,123L, null);
    static Users user2 = new Users(1L,1L, contact1);
    @Mock
    private UsersRepository repository;

    @BeforeEach
    void beforeEach() {
        underTest = new UsersServiceImpl(repository);
    }

    @Test
    void create_userCreateAndReturn() {
        when(repository.save(user1)).thenReturn(user1);
        assertEquals(user1, underTest.createUser(123L));
    }

    @Test
    void findUserByChatId_findUserAndReturn() {
        repository.save(user2);
        when(repository.findByChatId(1L)).thenReturn(Optional.of(user2));
        Users result = underTest.findByChatId(1L);
        assertEquals(user2, result);
    }

    @Test
    void findUserByChatId_userIsNotDb_returnUsersException() {
        when(repository.findByChatId(1L)).thenReturn(Optional.empty());
        UsersException ex = assertThrows(UsersException.class,
                () -> underTest.findByChatId(1L));
        assertEquals("failure identification", ex.getMessage());
    }

    @Test
    void updateUser_userUpdateAndReturn() {
        repository.save(user2);
        when(repository.findById(1L)).thenReturn(Optional.of(user2));
        when(repository.save(user2)).thenReturn(user2);
        Users result = underTest.updateUser(user2);
        assertEquals(user2, result);
    }
    @Test
    void updateUser_userIsNotRepository_returnUsersException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        UsersException ex = assertThrows(UsersException.class,
                () -> underTest.updateUser(user2));
        assertEquals("failure identification", ex.getMessage());
    }
}