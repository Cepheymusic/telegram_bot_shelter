package dev.pro.shelter.repository;

import dev.pro.shelter.model.DogAdopter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DogAdopterRepository extends JpaRepository<DogAdopter, Long> {
    Optional<DogAdopter> findByUsersId(Long userId);
}
