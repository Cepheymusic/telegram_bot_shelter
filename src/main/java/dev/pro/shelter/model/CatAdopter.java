package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cat_adopter")
public class CatAdopter{
    @Id
    private int id;
    private Long catId;
    private String address;

//    @OneToMany(mappedBy = "cat_adopter")
//    @JsonIgnore
//    private List<Cat> cats;



}
