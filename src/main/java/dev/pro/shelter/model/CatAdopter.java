package dev.pro.shelter.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class CatAdopter extends Users {
    private Long catId;
    private String address;


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
