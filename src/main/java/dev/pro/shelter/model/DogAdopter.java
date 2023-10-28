package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dog_adopter")
public class DogAdopter{
    @Id
    private int id;
    @Column(name = "dog_id")
    private Long dogId;
    @Column(name = "address")
    private String address;

//    @OneToMany(mappedBy = "dog_adopter")
//    @JsonIgnore
//    private List<Dog> dogs;


}
