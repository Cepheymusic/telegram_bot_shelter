package dev.pro.shelter.repository;

import dev.pro.shelter.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {
}
