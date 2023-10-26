package dev.pro.shelter.repository;

import dev.pro.shelter.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    boolean existsByChatId(Long chatId);
    Optional<Users> findByChatId(Long chatId);
}
