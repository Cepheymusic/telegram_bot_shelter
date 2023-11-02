package dev.pro.shelter.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class PetAdopter extends Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String address;

    public PetAdopter(Long id, Long chatId, Contact contact, String address) {
        super(id, chatId, contact);
        this.address = address;
    }

    public PetAdopter() {
        super();
    }
}
