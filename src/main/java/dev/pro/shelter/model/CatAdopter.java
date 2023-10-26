package dev.pro.shelter.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class CatAdopter extends Users {
    private Long catId;
    private String address;


    public CatAdopter(Integer id, long chatId, String username, Contact contact, Long catId) {
        super(id, chatId, username, contact);
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
