package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;




@Entity(name = "cat_adopter")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CatAdopter extends PetAdopter{
    private Integer catId;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CatAdopter that = (CatAdopter) o;
        return Objects.equals(catId, that.catId) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), catId, address);
    }

    @Override
    public String toString() {
        return "CatAdopter{" +
                "catId=" + catId +
                ", address='" + address + '\'' +
                '}';
    }
}
