package dev.pro.shelter.controller;

import dev.pro.shelter.model.Dog;
import dev.pro.shelter.repository.DogRepository;
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
class DogControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    @LocalServerPort
    int port;
    @MockBean
    DogRepository dogRepository;

    @AfterEach
    void afterEach() {
        dogRepository.deleteAll();
    }
    static Dog dog1 = new Dog(1L, "Math", 5, "chihuahua", true,null);
    @Test
    void createDog_returnStatus200AndDog() {
        when(dogRepository.save(dog1)).thenReturn(dog1);
        ResponseEntity<Dog> dogResponseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/dog", dog1, Dog.class);
        assertEquals(HttpStatus.OK, dogResponseEntity.getStatusCode());
        assertEquals(dog1.getName(), dogResponseEntity.getBody().getName());
    }

    @Test
    void readDog_dogNotInDb_returnStatus400AndMessage() {
        ResponseEntity<String> dogResponseEntity = restTemplate.getForEntity(
                "http://localhost:" + port + "/dog/" + dog1.getId(), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, dogResponseEntity.getStatusCode());
        assertEquals("Собакена нет", dogResponseEntity.getBody());
    }

    @Test
    void updateDog_ReturnStatus400AndDog() {
        ResponseEntity<String> dogResponseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/dog", HttpMethod.PUT,
                new HttpEntity<>(dog1), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, dogResponseEntity.getStatusCode());
    }

    @Test
    void deleteDog_returnStatus200AndDog() {
        when(dogRepository.findById(1L)).thenReturn(Optional.of(dog1));
        ResponseEntity<Dog> dogResponseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/dog/" + dog1.getId(),
                HttpMethod.DELETE, new HttpEntity<>(dog1), Dog.class);
        assertEquals(HttpStatus.OK, dogResponseEntity.getStatusCode());
        assertEquals(dog1.getName(), dogResponseEntity.getBody().getName());
    }

}