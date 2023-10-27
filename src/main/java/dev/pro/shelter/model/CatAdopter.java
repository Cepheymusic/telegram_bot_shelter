package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CatAdopter extends Users {
    private Long catId;
    private String address;

    @OneToMany(mappedBy = "cat_adopter")
    @JsonIgnore
    private List<Cat> cats;


    public CatAdopter(Integer id, long chatId, Contact contact, Long catId) {
        super(id, chatId, contact);
        this.catId = catId;
    }

    public CatAdopter() {
    }

    public Long getCatId() {
        return catId;
    }

    public void setCat(Long catId) {
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
        if (!(o instanceof CatAdopter that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getCatId(), that.getCatId()) && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCatId(), getAddress());
    }

    @Override
    public String toString() {
        return "CatAdopter{" +
                "cat=" + catId +
                ", address='" + address + '\'' +
                '}';
    }
}
