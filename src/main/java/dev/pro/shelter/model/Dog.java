package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "dog")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Dog extends Pet{

    @ManyToOne
    @JoinColumn(name = "idDogAdopter")
    private DogAdopter dogAdopter;

    public Dog(Long id, String name, int age, String breed, boolean healthRestrictions, DogAdopter dogAdopter) {
        super(id, name, age, breed, healthRestrictions);
        this.dogAdopter = dogAdopter;
    }

    public Dog() {
        super();
    }

    public DogAdopter getDogAdopter() {
        return dogAdopter;
    }

    public void setDogAdopter(DogAdopter dogAdopter) {
        this.dogAdopter = dogAdopter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(getDogAdopter(), dog.getDogAdopter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDogAdopter());
    }
}