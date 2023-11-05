package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

//@Entity
@MappedSuperclass
public abstract class Pet {
    private String name;
    private int age;
    private String breed;
    private boolean healthRestrictions;
    private String status; // выбор из списка параметров - ENUM: IN THE SHELTER, PROBATION, GIVEN TO ADOPTER

    public Pet(String name, int age, String breed, boolean healthRestrictions, String status) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.healthRestrictions = healthRestrictions;
        this.status = status;
    }

    public Pet() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && healthRestrictions == pet.healthRestrictions && Objects.equals(name, pet.name) &&
                Objects.equals(breed, pet.breed) && Objects.equals(status, pet.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getBreed(), isHealthRestrictions(), getStatus());
    }

    @Override
    public String toString() {
        return "Pet{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", healthRestrictions=" + healthRestrictions +
                ", status='" + status + '\'' +
                '}';
    }
}
