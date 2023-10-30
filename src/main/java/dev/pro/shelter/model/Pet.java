package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

//@Entity
@MappedSuperclass
public abstract class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
//    private Byte[] photo;
    private int age;
    private String breed;
    private boolean healthRestrictions;
    private String status; // выбор из списка параметров: in a shelter; probation; finally given to the owner

    public Pet(Integer id, String name, //Byte[] photo,
               int age, String breed, boolean healthRestrictions, String status) {
        this.id = id;
        this.name = name;
//        this.photo = photo;
        this.age = age;
        this.breed = breed;
        this.healthRestrictions = healthRestrictions;
        this.status = status;
    }

    public Pet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Byte[] getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(Byte[] photo) {
//        this.photo = photo;
//    }

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
        return age == pet.age && healthRestrictions == pet.healthRestrictions && Objects.equals(name, pet.name) && //Arrays.equals(photo, pet.photo) &&
                Objects.equals(breed, pet.breed) && Objects.equals(status, pet.status);
    }
    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Pet pet)) return false;
//        return getAge() == pet.getAge() && isHealthRestrictions() == pet.isHealthRestrictions() && Objects.equals(getName(), pet.getName()) && Arrays.equals(getPhoto(), pet.getPhoto()) && Objects.equals(getBreed(), pet.getBreed()) && Objects.equals(getDiet(), pet.getDiet()) && Objects.equals(getHabits(), pet.getHabits()) && Objects.equals(getStatus(), pet.getStatus());
//    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getAge(), getBreed(), isHealthRestrictions(), getStatus());
        result = 31 * result;
//                + Arrays.hashCode(getPhoto());
        return result;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", photo=" + Arrays.toString(photo) +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", healthRestrictions=" + healthRestrictions +
                ", status='" + status + '\'' +
                '}';
    }
}
