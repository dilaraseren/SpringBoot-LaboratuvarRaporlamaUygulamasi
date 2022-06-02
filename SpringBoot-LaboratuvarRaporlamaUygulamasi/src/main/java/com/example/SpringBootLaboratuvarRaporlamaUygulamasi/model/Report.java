package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_number")
    private Long reportNumber;

    @Column(name = "illnes_title")
    private String illnesTitle;

    @Column(name = "illnes_description")
    private String illnesDescription;

    @Column(name = "is_Active")
    private boolean isActive;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "report_date")
    private LocalDate reportDate;

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    @Column(name = "folder_path")
    private String folderPath;

    @ManyToOne
    private Laborant laborant;

    @ManyToOne
    private Patient patient;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @ManyToOne
    private Image image;



    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Laborant getLaborant() {
        return laborant;
    }

    public void setLaborant(Laborant laborant) {
        this.laborant = laborant;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(Long reportNumber) {
        this.reportNumber = reportNumber;
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

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }




}
