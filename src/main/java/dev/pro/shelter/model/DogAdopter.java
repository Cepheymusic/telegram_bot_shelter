package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "dog_adopter")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class DogAdopter extends PetAdopter{

    private Long dogId;


    public DogAdopter(Long id, Long chatId, Contact contact, String address) {
        super(id, chatId, contact, address);
    }

//    @OneToMany(mappedBy = "dog_adopter")
//    @JsonIgnore
//    private List<Dog> dogs;


    public Long getDogId() {
        return dogId;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }
}
