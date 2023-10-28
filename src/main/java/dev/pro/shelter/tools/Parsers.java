package dev.pro.shelter.tools;

import dev.pro.shelter.model.Contact;
//import dev.pro.shelter.model.Report;

public class Parsers {
    public static Contact parseContact(String text) {
        String[] ss = text.split(",");

        String name = ss[0];
        String surname = ss[1];
        String phone = ss[2];
        String email = ss[3];

        Contact contact = new Contact(name, surname, phone, email);
        return contact;
    }

//    public static Report parseReport(){return null;}
}
