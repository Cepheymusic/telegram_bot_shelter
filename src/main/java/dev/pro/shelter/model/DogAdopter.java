package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "dog_adopter")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class DogAdopter extends PetAdopter{

    private Integer dogId;


    public DogAdopter(Integer id, Long chatId, String name, String surname, String phone, String email, String address) {
        super(id, chatId, name, surname, phone, email, address);
    }

//    @OneToMany(mappedBy = "dog_adopter")
//    @JsonIgnore
//    private List<Dog> dogs;


    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }
}
