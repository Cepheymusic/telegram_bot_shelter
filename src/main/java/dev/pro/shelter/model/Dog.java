package dev.pro.shelter.model;

import javax.persistence.*;

@Entity(name = "dog")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Dog extends Pet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "dog_adopter_id")
    private DogAdopter adopter;

    public Dog(String name, int age, String breed, boolean healthRestrictions, String status, Long id, DogAdopter adopter) {
        super(name, age, breed, healthRestrictions, status);
        this.id = id;
        this.adopter = adopter;
    }

    public Dog() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DogAdopter getAdopter() {
        return adopter;
    }

    public void setAdopter(DogAdopter adopter) {
        this.adopter = adopter;
    }
}