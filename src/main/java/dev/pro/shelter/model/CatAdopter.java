package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity(name = "cat_adopter")
//@Inheritance(strategy = InheritanceType.JOINED)
public class CatAdopter extends Users{

    //@Id
    //@GeneratedValue(strategy = GenerationType.TABLE)
    //private Long id_adopter;
    private String address;
    private Long dogId;

    public CatAdopter(Long id, Long chatId, Contact contact, //Long id_adopter,
                      Users users, String address, Long dogId) {
        super(id, chatId, contact);
        //this.id_adopter = id_adopter;
        this.address = address;
        this.dogId = dogId;
    }

    public CatAdopter() {
    }

    //    @OneToMany(mappedBy = "cat_adopter")
//    @JsonIgnore
//    private List<Cat> cats;

}
