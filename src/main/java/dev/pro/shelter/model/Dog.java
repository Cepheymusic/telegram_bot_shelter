package dev.pro.shelter.model;
public class Dog extends Pet{
    public Dog(Long id, String name, Byte[] photo, int age, String breed, boolean healthRestrictions, String diet, String habits, String status) {
        super(id, name, photo, age, breed, healthRestrictions, diet, habits, status);
    }
}
