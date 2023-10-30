package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


//@Entity(name = "cat_adopter")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CatAdopter extends PetAdopter{
    private Long catId;

    public CatAdopter(Long id, Long chatId, String name, String surname, String phone, String email, String address) {
        super(id, chatId, name, surname, phone, email, address);
    }

    public CatAdopter() {
        super();
    }

//    @OneToMany(mappedBy = "cat_adopter")
//    @JsonIgnore
//    private List<Cat> cats;




    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

}
