package dev.pro.shelter.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_users")
    private Users users;
//     private Byte[] photo;
    private String diet;
    private String health;
    private String habits;
    private LocalDate reportDate; //формат даты формат даты YYYY-MM-DD
    private LocalDate lastReportDate; //формат даты формат даты YYYY-MM-DD
    @Column(name = "resolution")
    @Enumerated(EnumType.STRING)
    private EnumResolution resolution; //по умолчанию - на испытательный срок PROBATION;
    private boolean sentMessage; //по умолчанию - ложно


    public Report(Long id, /*Users users,
                  Byte[] photo,*/ String diet, String health, String habits,
                  LocalDate reportDate, LocalDate lastReportDate, EnumResolution resolution, boolean sentMessage) {
        this.id = id;
//        this.users = users;
//        this.idUsers = idUsers;
//        this.photo = photo;
        this.diet = diet;
        this.health = health;
        this.habits = habits;
        this.reportDate = reportDate;
        this.lastReportDate = lastReportDate;
        this.resolution = resolution;
        this.sentMessage = sentMessage;
    }

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

//    public Byte[] getPhoto() {
//        return photo;
//    }

//    public void setPhoto(Byte[] photo) {
//        this.photo = photo;
//    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public LocalDate getLastReportDate() {
        return lastReportDate;
    }

    public void setLastReportDate(LocalDate lastReportDate) {
        this.lastReportDate = lastReportDate;
    }

    public EnumResolution getResolution() {
        return resolution;
    }

    public void setResolution(EnumResolution resolution) {
        this.resolution = resolution;
    }

    public boolean isSentMessage() {
        return sentMessage;
    }

    public void setSentMessage(boolean sentMessage) {
        this.sentMessage = sentMessage;
    }


}
