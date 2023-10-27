package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//@Entity
//@Table(name = "user")
public class User {
    private String name;
    private String numberPhone;
    private String mail;
    private Long chatId;
//    @OneToMany(mappedBy = "cat, dog") //?????????
//    private List<Pet> pets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(numberPhone, user.numberPhone) && Objects.equals(mail, user.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberPhone, mail);
    }

    public User(String name, String numberPhone, String mail) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.mail = mail;
    }

    public User(Long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
