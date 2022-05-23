package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto;


import java.util.Date;

public class ReportUpdateDto {

    private long id;
    private String illnesTitle;
    private String illnesDescription;
    private String folderPath;
    private Long reportNumber;
    private Date reportDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long laborantId;

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

    public Long getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(Long reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public long getLaborantId() {
        return laborantId;
    }

    public void setLaborantId(long laborantId) {
        this.laborantId = laborantId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    private long patientId;
}
