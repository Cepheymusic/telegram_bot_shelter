package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String breed;
    private boolean healthRestrictions;

    public Dog(String name, int age, String breed, boolean healthRestrictions) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.healthRestrictions = healthRestrictions;
    }

    public Long getId() {
        return id;
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
        Dog dog = (Dog) o;
        return age == dog.age && healthRestrictions == dog.healthRestrictions && Objects.equals(id, dog.id) && Objects.equals(name, dog.name) && Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, breed, healthRestrictions);
    }
}