package dev.pro.shelter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long chatId;
    private String username;
    @Embedded
    private Contact contact;

    public Users(Integer id, Long chatId, String username, Contact contact) {
        this.id = id;
        this.chatId = chatId;
        this.username = username;
        this.contact = contact;
    }

    public Users() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users user)) return false;
        return getChatId() == user.getChatId() && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getContact(), user.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatId(), getUsername(), getContact());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", username='" + username + '\'' +
                ", contact=" + contact +
                '}';
    }
}
