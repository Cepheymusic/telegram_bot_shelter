package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "cat_adopter")
public class CatAdopter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    private long idUser;
    @OneToOne
    private Users users;
    private String address;
    private LocalDate dateStartProbation; //формат даты YYYY-MM-DD

    @OneToMany(mappedBy = "cat_adopter")
    @JsonIgnore
    private List<Cat> cats;


//    public CatAdopter(Long id, long idUser, String address, LocalDate dateStartProbation) {
//        this.id = id;
//        this.idUser = idUser;
//        this.address = address;
//        this.dateStartProbation = dateStartProbation;
//    }


    public CatAdopter(Long id, Users users, String address, LocalDate dateStartProbation) {
        this.id = id;
        this.users = users;
        this.address = address;
        this.dateStartProbation = dateStartProbation;
    }

    public CatAdopter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}


