package dev.pro.shelter.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class PetAdopter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Long chatId;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String address;

    public PetAdopter(Integer id, Long chatId, String name, String surname, String phone, String email, String address) {
        this.id = id;
        this.chatId = chatId;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
