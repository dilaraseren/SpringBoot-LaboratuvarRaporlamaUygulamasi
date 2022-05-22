package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private UUID number;

    @Column(name = "illnes_title")
    private String illnesTitle;

    @Column(name = "illnes_description")
    private String illnesDescription;

    @Column(name = "date")
    private String date;

    @Column(name = "folder_path")
    private String folderPath;

    @ManyToOne
    @JoinColumn(name = "laborantId")
    private Laborant laborant;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getNumber() {
        return number;
    }

    public void setNumber(UUID number) {
        this.number = number;
    }

    public String getIllnesTitle() {
        return illnesTitle;
    }

    public void setIllnesTitle(String illnesTitle) {
        this.illnesTitle = illnesTitle;
    }

    public String getIllnesDescription() {
        return illnesDescription;
    }

    public void setIllnesDescription(String illnesDescription) {
        this.illnesDescription = illnesDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }




}
