package dev.pro.shelter.repository;

import dev.pro.shelter.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer,Integer> {
}
