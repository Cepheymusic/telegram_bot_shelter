package dev.pro.shelter.repository;

import dev.pro.shelter.model.Cat;
import dev.pro.shelter.model.CatAdopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long> {

    }
