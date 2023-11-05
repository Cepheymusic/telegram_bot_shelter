package dev.pro.shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private Long id;
    private Long chatId;

    @Embedded
    private Contact contact;

    @OneToMany(mappedBy = "report")
    @JsonIgnore
    private List<Report> reports;

    @OneToOne(mappedBy = "id_cat_adopter")
    private  CatAdopter catAdopter;
    @OneToOne(mappedBy = "id_dog_adopter")
    private DogAdopter dogAdopter;


    public Users(Long id, Long chatId, Contact contact) {
        this.id = id;
        this.chatId = chatId;
        this.contact = contact;
    }

    public Users() {
    }

    public Long getIdUsers() {
        return id;
    }

    public void setIdUsers(Long id) {
        this.id = id;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", contact=" + contact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(chatId, users.chatId) && Objects.equals(contact, users.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, contact);
    }
}
