package dev.pro.shelter.util;

public class Parsers {
    public static Contacts parseContact(String text) {
        String[] ss = text.split(",");

        String name = ss[0];
        String phone = ss[1];
        String email = ss[2];

        Contacts contacts = new Contacts(name, phone, email);
        return contacts;
    }
}
