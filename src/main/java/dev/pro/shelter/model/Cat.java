package dev.pro.shelter.model;


import javax.persistence.Entity;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Cat {
    long petId;
    String name;
    Byte[] photo;
    int age;
    String bread;
    String diet; // выбор из списка параметров
    String habits; // свободное описание
    String status; // выбор из списка параметров: in a shelter; probation; finally given to the owner

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
        return getAge() == cat.getAge() && Objects.equals(getName(), cat.getName()) && Arrays.equals(getPhoto(), cat.getPhoto()) && Objects.equals(getBread(), cat.getBread()) && Objects.equals(getDiet(), cat.getDiet()) && Objects.equals(getHabits(), cat.getHabits()) && Objects.equals(getStatus(), cat.getStatus());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getAge(), getBread(), getDiet(), getHabits(), getStatus());
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
                ", diet='" + diet + '\'' +
                ", habits='" + habits + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
