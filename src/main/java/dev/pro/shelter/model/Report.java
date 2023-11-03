package dev.pro.shelter.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private long userId;
    private long petId;
    @Embedded
    private PhotoPet photo;
    private String diet;
    private String habits;
    private byte probationDays;
    private LocalDateTime lastReportDate;

//
//
////    @ManyToMany
////    List<CatAdopter> catAdopters;
////    @ManyToMany
////    List<DogAdopter> dogAdopters;
//
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(referencedColumnName = "cat_adopter_id")
////    private CatAdopter catAdopters;
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(referencedColumnName = "dog_adopter_id")
////    private DogAdopter dogAdopters;
//    @ManyToOne
//    @JoinColumn(referencedColumnName = "cat_adopter_id")
//    private CatAdopter catAdopters;
//    @ManyToOne
//    @JoinColumn(referencedColumnName = "dog_adopter_id")
//    private DogAdopter dogAdopters;
//
////
//
}
