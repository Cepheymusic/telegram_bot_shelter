package dev.pro.shelter.model;

import javax.persistence.*;

@Entity(name = "dog")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Dog extends Pet{
//    @ManyToOne
//    @JoinColumn(name = "dog_adopter_id")
//    private DogAdopter adopter;

    public Dog(Long id, String name, Byte[] photo, int age, String breed, boolean healthRestrictions, String diet, String habits, String status) {
        super(id, name, photo, age, breed, healthRestrictions, diet, habits, status);
    }
}