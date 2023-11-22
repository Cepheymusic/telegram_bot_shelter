package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "cat")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cat extends Pet {
    @ManyToOne
    @JoinColumn(name = "idCatAdopter")
    private CatAdopter catAdopter;

    public Cat(Long id, String name, int age, String breed, boolean healthRestrictions, CatAdopter catAdopter) {
        super(id, name, age, breed, healthRestrictions);
        this.catAdopter = catAdopter;
    }

    public Cat() {
        super();
    }

    public CatAdopter getCatAdopter() {
        return catAdopter;
    }

    public void setCatAdopter(CatAdopter catAdopter) {
        this.catAdopter = catAdopter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(getCatAdopter(), cat.getCatAdopter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCatAdopter());
    }
}
