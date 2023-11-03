package dev.pro.shelter.model;

import javax.persistence.*;

@Entity(name = "cat")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cat extends Pet {
//    @ManyToOne
//    @JoinColumn(name = "cat_adopter_id")
//    private CatAdopter adopter;
    public Cat(Long id, String name, PhotoPet photo, int age, String breed, boolean healthRestrictions, String status) {
        super(id, name, photo, age, breed, healthRestrictions, status);
    }

    public Cat() {
        super();
    }
}
