package dev.pro.shelter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Volunteer {
   @Id
   @GeneratedValue
   private Integer id;
   private Long idChat;
   private String name;
   private String phone;
   private String email;

    public Volunteer(Integer id, Long idChat, String name, String phone, String email) {
        this.id = id;
        this.idChat = idChat;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Volunteer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIdChat() {
        return idChat;
    }

    public void setIdChat(Long idChat) {
        this.idChat = idChat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
