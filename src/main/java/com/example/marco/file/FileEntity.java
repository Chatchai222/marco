package com.example.marco.file;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class FileEntity {
    
    @Id
    @SequenceGenerator(
        name = "fileEntitySequence",
        sequenceName = "fileEntitySequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "fileEntitySequence"
    )
    private Long fileId;

    private String name;
    private String contentType;
    private Long size;

    @Lob
    private byte[] data;

    public FileEntity(){

    }

    public FileEntity(String name, String contentType, Long size, byte[] data) {
        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.data = data;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long id) {
        this.fileId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


    
}
