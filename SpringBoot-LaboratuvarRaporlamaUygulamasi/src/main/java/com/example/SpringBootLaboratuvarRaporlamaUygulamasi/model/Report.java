package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model;

import javax.persistence.*;
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

    @Column(name = "date")
    private String date;

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
