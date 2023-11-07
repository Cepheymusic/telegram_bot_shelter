package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "dog_adopter")
public class DogAdopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDogAdopter")
    private Long idDogAdopter;
    //    private long idUser;
    @OneToOne
    @JoinColumn(name = "id_users")
    private Users users;
    private String address;
    private LocalDate dateStartProbation; //формат даты формат даты YYYY-MM-DD


    @OneToMany(mappedBy = "dogAdopter")
    @JsonIgnore
    private List<Dog> dogs;


    public DogAdopter(Long idDogAdopter, Users users, String address, LocalDate dateStartProbation) {
        this.idDogAdopter = idDogAdopter;
        this.users = users;
        this.address = address;
        this.dateStartProbation = dateStartProbation;
    }

    public DogAdopter() {
    }

    public Long getIdDogAdopter() {
        return idDogAdopter;
    }

    public void setIdDogAdopter(Long id) {
        this.idDogAdopter = idDogAdopter;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateStartProbation() {
        return dateStartProbation;
    }

    public void setDateStartProbation(LocalDate dateStartProbation) {
        this.dateStartProbation = dateStartProbation;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
