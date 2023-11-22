package dev.pro.shelter.repository;

import dev.pro.shelter.model.Cat;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CatRepository extends JpaRepository<Cat, Long> {

    }
