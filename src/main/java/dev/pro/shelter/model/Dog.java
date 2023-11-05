package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "dog")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Dog extends Pet{

    @ManyToOne
    @JoinColumn(name = "id_dog_adopter")
    private DogAdopter adopter;

    public Dog(Long id, String name, int age, String breed, boolean healthRestrictions, String status, DogAdopter adopter) {
        super(id, name, age, breed, healthRestrictions, status);
        this.adopter = adopter;
    }

    public Dog() {
        super();
    }

    public DogAdopter getAdopter() {
        return adopter;
    }

    public void setAdopter(DogAdopter adopter) {
        this.adopter = adopter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(getAdopter(), dog.getAdopter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAdopter());
    }
}