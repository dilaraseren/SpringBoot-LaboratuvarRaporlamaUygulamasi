package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto;

import java.util.Date;

public class ReportDto {

    private String illnesTitle;
    private String illnesDescription;
    private String folderPath;
    private Long reportNumber;
    private Date reportDate;
    private long laborantId;
    private long patientId;

    public Long getReportNumber() {
        return reportNumber;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public void setReportNumber(Long reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
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
}
