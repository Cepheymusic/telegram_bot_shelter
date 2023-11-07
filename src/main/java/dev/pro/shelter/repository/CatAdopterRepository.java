package dev.pro.shelter.repository;

import dev.pro.shelter.model.CatAdopter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatAdopterRepository extends JpaRepository<CatAdopter, Long> {

//    boolean existByIdCatAdopter(Long id);

    //    @Query(value = "select u from Users u Where u.chatId = ?1")
    Optional<CatAdopter> findByUsersId(Long userId);
}
