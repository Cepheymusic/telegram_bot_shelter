package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

//@Entity
@MappedSuperclass
public abstract class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String breed;
    private boolean healthRestrictions;

    public Pet(Long id, String name, int age, String breed, boolean healthRestrictions) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.healthRestrictions = healthRestrictions;
    }

    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isHealthRestrictions() {
        return healthRestrictions;
    }

    public void setHealthRestrictions(boolean healthRestrictions) {
        this.healthRestrictions = healthRestrictions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && healthRestrictions == pet.healthRestrictions && Objects.equals(name, pet.name) &&
                Objects.equals(breed, pet.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getBreed(), isHealthRestrictions());
    }

    @Override
    public String toString() {
        return "Pet{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", healthRestrictions=" + healthRestrictions +
                '}';
    }
}
