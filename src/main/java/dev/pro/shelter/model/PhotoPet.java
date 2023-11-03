package dev.pro.shelter.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
@Embeddable
public class PhotoPet {
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "file_size")
    private Long fileSize;
    @Column(name = "media_type")
    private String mediaType;
    @Column(name = "data")
    private byte[] data;
}

