package dev.pro.shelter.service;

import dev.pro.shelter.model.User;

public class ParsUserData {
    public static User parseContact(String text) {
        String[] ss = text.split(",");

        String name = ss[0];
        String numberPhone = ss[1];
        String mail = ss[2];

        return new User(name, numberPhone, mail);
    }
}
