package dev.pro.shelter.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long petId;
    private String name;
    private Byte[] photo;
    private int age;
    private String bread;
    private boolean healthRestrictions;
    private String diet; // выбор из списка параметров
    private String habits; // свободное описание
    private String status; // выбор из списка параметров: in a shelter; probation; finally given to the owner

    public Cat(long petId, String name, Byte[] photo, int age, String bread, boolean healthRestrictions, String diet, String habits, String status) {
        this.petId = petId;
        this.name = name;
        this.photo = photo;
        this.age = age;
        this.bread = bread;
        this.healthRestrictions = healthRestrictions;
        this.diet = diet;
        this.habits = habits;
        this.status = status;
    }

    public Cat() {
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public boolean isHealthRestrictions() {
        return healthRestrictions;
    }

    public void setHealthRestrictions(boolean healthRestrictions) {
        this.healthRestrictions = healthRestrictions;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
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
        if (!(o instanceof Cat cat)) return false;
        return getAge() == cat.getAge() && isHealthRestrictions() == cat.isHealthRestrictions() && Objects.equals(getName(), cat.getName()) && Arrays.equals(getPhoto(), cat.getPhoto()) && Objects.equals(getBread(), cat.getBread()) && Objects.equals(getDiet(), cat.getDiet()) && Objects.equals(getHabits(), cat.getHabits()) && Objects.equals(getStatus(), cat.getStatus());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getAge(), getBread(), isHealthRestrictions(), getDiet(), getHabits(), getStatus());
        result = 31 * result + Arrays.hashCode(getPhoto());
        return result;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", age=" + age +
                ", bread='" + bread + '\'' +
                ", healthRestrictions=" + healthRestrictions +
                ", diet='" + diet + '\'' +
                ", habits='" + habits + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
