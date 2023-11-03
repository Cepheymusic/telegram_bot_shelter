package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "dog_adopter")
//@Inheritance(strategy = InheritanceType.JOINED)
public class DogAdopter extends Users{
    //@Id
    //@GeneratedValue(strategy = GenerationType.TABLE)
    //private Long id_adopter;
    private String address;
    private Long dogId;

    public DogAdopter(Long id, Long chatId, Contact contact, //Long id_adopter,
                      String address, Long dogId) {
        super(id, chatId, contact);
        //this.id_adopter = id_adopter;
        this.address = address;
        this.dogId = dogId;
    }

    public DogAdopter() {
    }
    //    @OneToMany(mappedBy = "dog_adopter")
//    @JsonIgnore
//    private List<Dog> dogs;

}
