package dev.pro.shelter.model;

public enum EnumsInfo {
    INFO_DOG_SHELTER("Благотворительная организация помощи бездомным собакам. " +
            "Наша миссия - найти постоянные дома для бездомных собак. " +
            "Потенциальные хозяева могут посетить приют, ознакомиться с питомцами, и, при желании, забрать собаку домой"),
    SEARCH_DOG_SHELTER("Мы находимся по адресу: просп. имени 50 лет Октября, 118А, Саратов, офис 406." +
            "Работаем пн-пт - с 9:00 до 18:00, сб-вс - с 10:00 до 15:00"),
    SECURITY_DATA("Охрана: Тел.+79998883311"),
    SAFETY_PRECAUTIONS("Запрещается:\n" +
            "Самостоятельно открывать выгулы и вольеры без разрешения работника приюта.\n" +
            "Кормить животных. Этим Вы можете спровоцировать драку. Угощения разрешены только постоянным опекунам и волонтерам, во время прогулок с животными на поводке.\n" +
            "Оставлять после себя мусор на территории приюта и прилегающей территории.\n" +
            "Подходить близко к вольерам и гладить собак через сетку на выгулах. Животные могут быть агрессивны!\n" +
            "Кричать, размахивать руками, бегать между будками или вольерами, пугать и дразнить животных.\n" +
            "Посещение приюта для детей дошкольного и младшего школьного возраста без сопровождения взрослых.\n" +
            "Нахождение на территории приюта детей среднего и старшего школьного возраста без  сопровождения взрослых или письменной справки-разрешения от родителей или законных представителей.\n" +
            "Самостоятельно заходить в кошатник без разрешения сотрудников приюта.\n" +
            "Подходить к лошади без разрешения работника приюта. Угощать лошадь можно только в присутствие работника приюта.\n" +
            "Посещение приюта в состоянии алкогольного, наркотического опьянения."),
    SEND_CONTACT("Отправьте контактные данные в формате: Sergey, Sergeev, 89991112233, mmm@gmail.com"),
    VOLUNTEER("Привет, я волонтёр");
    private String text;

    EnumsInfo(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    @Override
    public String toString() {
        return "EnumsInfo{" +
                "text='" + text + '\'' +
                '}';
    }

}
