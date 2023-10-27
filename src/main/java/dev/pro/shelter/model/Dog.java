package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "dog")

public class Dog extends Pet{
    public Dog(Long id, String name, Byte[] photo, int age, String breed, boolean healthRestrictions, String diet, String habits, String status) {
        super(id, name, photo, age, breed, healthRestrictions, diet, habits, status);
    }
}
