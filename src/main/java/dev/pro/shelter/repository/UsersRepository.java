package dev.pro.shelter.repository;

import dev.pro.shelter.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    boolean existsByChatId(Long chatId);
    @Query(value = "select u from Users u Where u.chatId = ?1")
    Optional<Users> findByChatId(Long chatId);
}
