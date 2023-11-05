package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "cat")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cat extends Pet {
    @ManyToOne
    @JoinColumn(name = "id_cat_adopter")
    private CatAdopter adopter;

    public Cat(Long id, String name, int age, String breed, boolean healthRestrictions, String status, CatAdopter adopter) {
        super(id, name, age, breed, healthRestrictions, status);
        this.adopter = adopter;
    }

    public Cat() {
        super();
    }

    public CatAdopter getAdopter() {
        return adopter;
    }

    public void setAdopter(CatAdopter adopter) {
        this.adopter = adopter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(getAdopter(), cat.getAdopter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAdopter());
    }
}
