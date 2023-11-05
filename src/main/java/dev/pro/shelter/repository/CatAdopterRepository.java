package dev.pro.shelter.repository;

import dev.pro.shelter.model.CatAdopter;
import dev.pro.shelter.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CatAdopterRepository extends JpaRepository<CatAdopter, Long> {

    boolean existById(Long id);

    //    @Query(value = "select u from Users u Where u.chatId = ?1")
    Optional<CatAdopter> findByUserId(Long userId);
}
