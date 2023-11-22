package dev.pro.shelter.service.impl;

import dev.pro.shelter.exception.CatNotFoundException;
import dev.pro.shelter.model.Cat;
import dev.pro.shelter.repository.CatRepository;
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
class CatServiceImplTest {
    @InjectMocks
    CatServiceImpl underTest;
    @Mock
    private CatRepository repository;
    static Cat cat1 = new Cat(1L, "Caty", 5, "mainkun", true, null);

    @BeforeEach
    void beforeEach() {
        underTest = new CatServiceImpl(repository);
    }

    @Test
    void createCat_saveCatInRepositoryAndReturn() {
        when(repository.save(cat1)).thenReturn(cat1);
        Cat result = underTest.createCat(cat1);
        assertEquals(cat1, result);
    }

    @Test
    void readCat_catInRepository_findCatAndReturn() {
        when(repository.findById(1L)).thenReturn(Optional.of(cat1));
        Cat result = underTest.readCat(1L);
        assertEquals(cat1, result);
    }
    @Test
    void readCat_catIsNotRepository_returnCatNotFoundException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        CatNotFoundException ex = assertThrows(CatNotFoundException.class,
                () -> underTest.readCat(1L));
        assertEquals("Котэ нет", ex.getMessage());
    }

    @Test
    void updateCat_updateAndReturnCat() {
        when(repository.findById(1L)).thenReturn(Optional.of(cat1));
        when(repository.save(cat1)).thenReturn(cat1);
        Cat result = underTest.updateCat(cat1);
        assertEquals(cat1, result);
    }
    @Test
    void updateCat_catIsNotRepository_returnCatNotFoundException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        CatNotFoundException ex = assertThrows(CatNotFoundException.class,
                () -> underTest.updateCat(cat1));
        assertEquals("Котэ нет", ex.getMessage());
    }
    @Test
    void deleteCat_catIsNotRepository_returnCatNotFoundException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        CatNotFoundException ex = assertThrows(CatNotFoundException.class,
                () -> underTest.deleteCat(1L));
        assertEquals("Котэ нет", ex.getMessage());
    }

}