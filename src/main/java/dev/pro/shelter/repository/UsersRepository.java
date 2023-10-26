package dev.pro.shelter.repository;

import dev.pro.shelter.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findByChatId(Long chatId);
}
