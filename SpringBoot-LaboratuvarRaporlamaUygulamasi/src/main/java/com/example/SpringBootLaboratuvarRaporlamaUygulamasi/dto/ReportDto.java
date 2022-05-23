package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto;

public class ReportDto {

    private String illnesTitle;
    private String illnesDescription;
    private String date;
    private String folderPath;
    private Long reportNumber;
    private long  laborantId;
    private long patientId;

    public Long getReportNumber() {
        return reportNumber;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
