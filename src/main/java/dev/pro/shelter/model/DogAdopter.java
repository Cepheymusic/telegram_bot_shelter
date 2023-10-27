package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class DogAdopter extends Users {
    private Long dogId;
    private String address;

    @OneToMany(mappedBy = "dog_adopter")
    @JsonIgnore
    private List<Dog> dogs;

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
        if (!(o instanceof DogAdopter that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getDogId(), that.getDogId()) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDogId(), address);
    }

    @Override
    public String toString() {
        return "DogAdopter{" +
                "dog=" + dogId +
                ", address='" + address + '\'' +
                '}';
    }
}
