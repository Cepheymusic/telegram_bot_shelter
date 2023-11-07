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
    @Column(name = "id")
    private Long idCatAdopter;
    //    private long idUser;
    @OneToOne
    @JoinColumn(name = "id_users")
    private Users users;
    private String address;
    private LocalDate dateStartProbation; //формат даты YYYY-MM-DD

    @OneToMany(mappedBy = "catAdopter")
    @JsonIgnore
    private List<Cat> cats;


    public CatAdopter(Long idCatAdopter, Users users, String address, LocalDate dateStartProbation) {
        this.idCatAdopter = idCatAdopter;
        this.users = users;
        this.address = address;
        this.dateStartProbation = dateStartProbation;
    }

    public CatAdopter() {
    }

    public Long getIdCatAdopter() {
        return idCatAdopter;
    }

    public void setIdCatAdopter(Long id) {
        this.idCatAdopter = idCatAdopter;
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


