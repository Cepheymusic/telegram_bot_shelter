package dev.pro.shelter.controller;

import dev.pro.shelter.model.Cat;
import dev.pro.shelter.repository.CatRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CatControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    @LocalServerPort
    int port;
    @MockBean
    CatRepository catRepository;

    @AfterEach
    void afterEach() {
        catRepository.deleteAll();
    }
    static Cat cat1 = new Cat(1L, "Caty", 5, "mainkun", true, null);
    @Test
    void createCat_returnStatus200AndCat() {
        when(catRepository.save(cat1)).thenReturn(cat1);
        ResponseEntity<Cat> catResponseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/cat", cat1, Cat.class);
        assertEquals(HttpStatus.OK, catResponseEntity.getStatusCode());
        assertEquals(cat1.getName(), catResponseEntity.getBody().getName());
    }

    @Test
    void readCat_catNotInDb_returnStatus400AndMessage() {
        ResponseEntity<String> catResponseEntity = restTemplate.getForEntity(
                "http://localhost:" + port + "/cat/" + cat1.getId(), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, catResponseEntity.getStatusCode());
        assertEquals("Котэ нет", catResponseEntity.getBody());
    }

    @Test
    void updateCat_ReturnStatus400AndCat() {
        ResponseEntity<String> catResponseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/cat", HttpMethod.PUT,
                new HttpEntity<>(cat1), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, catResponseEntity.getStatusCode());
    }

    @Test
    void deleteCat_returnStatus200AndCat() {
        when(catRepository.findById(1L)).thenReturn(Optional.of(cat1));
        ResponseEntity<Cat> catResponseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/cat/" + cat1.getId(),
                HttpMethod.DELETE, new HttpEntity<>(cat1), Cat.class);
        assertEquals(HttpStatus.OK, catResponseEntity.getStatusCode());
        assertEquals(cat1.getName(), catResponseEntity.getBody().getName());
    }
}