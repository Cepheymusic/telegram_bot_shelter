package dev.pro.shelter.model;

import javax.persistence.Entity;

@Entity(name = "cat")
public class Cat extends Pet {
    public Cat(Long id, String name, Byte[] photo, int age, String breed, boolean healthRestrictions, String diet, String habits, String status) {
        super(id, name, photo, age, breed, healthRestrictions, diet, habits, status);
    }
}
