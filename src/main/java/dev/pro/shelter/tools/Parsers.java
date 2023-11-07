package dev.pro.shelter.tools;

import dev.pro.shelter.exception.ReportException;
import dev.pro.shelter.model.Contact;

public class Parsers {
    public static Contact parseContact(String text) {
        String[] contInfo = text.split(" ", 2);
        String[] ss = contInfo[1].split(",");

        String name = ss[0];
        String surname = ss[1];
        String phone = ss[2];
        String email = ss[3];

        Contact contact = new Contact(name, surname, phone, email);
        return contact;
    }

    public static String[] parseReportText(String caption) {
        String[] reportMsg = caption.split(" ", 2);
        String[] reportText = reportMsg[1].split("&");
        if(reportText.length!=3){
            throw new ReportException("Неверно оформлено текстовое сообщение. Пожалуйста, оформите отчет по образцу, " +
                    "отделите блоки про питание, самочувствие и поведение питомца символом & " +
                    "и отправьте повторно полный отчет согласно образцу");
        }
        //сделать проверку на пустой блок и на блок, где только пробелы
        return reportText;
    }
}
