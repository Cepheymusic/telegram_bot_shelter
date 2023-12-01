package dev.pro.shelter.controller;

import dev.pro.shelter.model.*;
import dev.pro.shelter.repository.CatAdopterRepository;
import dev.pro.shelter.repository.DogAdopterRepository;
import dev.pro.shelter.repository.DogRepository;
import dev.pro.shelter.repository.UsersRepository;
import dev.pro.shelter.service.DogAdopterService;
import org.apache.catalina.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
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

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class DogAdopterControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    CatAdopterRepository catAdopterRepository;
    @MockBean
    DogAdopterRepository dogAdopterRepository;
    @MockBean
    UsersRepository usersRepository;
    @MockBean
    DogRepository dogRepository;
    @LocalServerPort
    int port;
    @AfterEach
    void afterEach() {
        dogAdopterRepository.deleteAll();
        catAdopterRepository.deleteAll();
        dogRepository.deleteAll();
    }

    static Contact contact = new Contact("Test", "Test", "+79878888888", "ggg@gmail.com");
    static Users user1 = new Users(1L, 123L, contact);
    static DogAdopter dogAdopter = new DogAdopter(1L, null, "test", null);
    static Dog dog = new Dog(1L, "Test", 10, "test", true, dogAdopter);

    @Test
    void createDogAdopter_returnStatus200AndDogAdopter() {

        //when(dogAdopterRepository.findByUsersId(1L)).thenReturn(Optional.of(dogAdopter));
        when(dogAdopterRepository.save(dogAdopter)).thenReturn(dogAdopter);
        ResponseEntity<DogAdopter> dogAdopterResponseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/dogAdopter", "?idUser=1&idPet=1&address=New%20York%2C%20Middle%20Street%2C%20245", null);
        assertEquals(HttpStatus.OK, dogAdopterResponseEntity.getStatusCode());
        assertEquals(dogAdopter.getAddress(), dogAdopterResponseEntity.getBody().getAddress());
    }

    @Test
    void readAdopter() {
        when(dogRepository.findById(1L)).thenReturn(Optional.of(dog));
        when(dogAdopterRepository.findByUsersId(1L)).thenReturn(Optional.of(dogAdopter));
        when(usersRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(dogAdopterRepository.findById(1L)).thenReturn(Optional.of(dogAdopter));
        ResponseEntity<?> dogAdopterResponseEntity = restTemplate.getForEntity(
                "http://localhost:" + port + "/adopters/" + "dog"
                        + dog.getId(),
                null);
        Mockito.verify(dogAdopterRepository, Mockito.times(1)).findById(any());
    }

    @Test
    void updateAdopter() {
//        when(usersRepository.findById(1L)).thenReturn(Optional.of(user1));
//        ResponseEntity<?> catResponseEntity = restTemplate.exchange(
//                "http://localhost:" + port + "/adopters", HttpMethod.PUT,
//                new HttpEntity<>(), String.class);
//        Mockito.verify(dogAdopterRepository, Mockito.times(1)).save(any());
    }

    @Test
    void deleteAdopter() {
    }
}