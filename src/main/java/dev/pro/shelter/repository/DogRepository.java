package dev.pro.shelter.repository;

import dev.pro.shelter.model.CatAdopter;
import dev.pro.shelter.model.Dog;
import dev.pro.shelter.model.DogAdopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

}

