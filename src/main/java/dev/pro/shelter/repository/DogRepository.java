package dev.pro.shelter.repository;

import dev.pro.shelter.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
