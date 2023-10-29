package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity(name = "cat_adopter")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CatAdopter extends PetAdopter{
    private Integer catId;

    public CatAdopter(Integer id, Long chatId, String name, String surname, String phone, String email, String address) {
        super(id, chatId, name, surname, phone, email, address);
    }

//    @OneToMany(mappedBy = "cat_adopter")
//    @JsonIgnore
//    private List<Cat> cats;




    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

}
