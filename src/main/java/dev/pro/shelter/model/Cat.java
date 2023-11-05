package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cat")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cat extends Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cat_adopter_id")
    private CatAdopter adopter;

    public Cat(String name, int age, String breed, boolean healthRestrictions, String status, Long id) {
        super(name, age, breed, healthRestrictions, status);
        this.id = id;
    }

    public Cat() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CatAdopter getAdopter() {
        return adopter;
    }

    public void setAdopter(CatAdopter adopter) {
        this.adopter = adopter;
    }
}
