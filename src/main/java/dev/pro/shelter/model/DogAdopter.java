package dev.pro.shelter.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class DogAdopter extends Users {
    private Long dogId;
    private String address;

    public DogAdopter(Integer id, long chatId, Contact contact, Long dogId, String address) {
        super(id, chatId, contact);
        this.dogId = dogId;
        this.address = address;
    }

    public DogAdopter() {
    }

    public Long getDogId() {
        return dogId;
    }

    public void setDog(Long dogId) {
        this.dogId = dogId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DogAdopter that = (DogAdopter) o;
        return Objects.equals(dogId, that.dogId) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dogId, address);
    }

    @Override
    public String toString() {
        return "DogAdopter{" +
                "dogId=" + dogId +
                ", address='" + address + '\'' +
                '}';
    }
}
