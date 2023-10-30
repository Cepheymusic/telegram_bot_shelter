package dev.pro.shelter.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue
    private long Id;
    private long userId;
    private long petId;
    private Byte[] photoPet;
    private String diet; // выбор из списка параметров
    private String habits; // свободное описание
    private byte probationDays;
    private LocalDateTime lastReportDate;
    private boolean missedOneDay;
    private boolean missedTwoDay;
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
////    private String filePath;
////    /**
////     * Size of sent file
////     * @param fileSize
////     */
////    private Long fileSize;
////    /**
////     * Byte array for file transfer
////     * @param data
////     */
////    @Lob
////    private byte[] data;
//
}
