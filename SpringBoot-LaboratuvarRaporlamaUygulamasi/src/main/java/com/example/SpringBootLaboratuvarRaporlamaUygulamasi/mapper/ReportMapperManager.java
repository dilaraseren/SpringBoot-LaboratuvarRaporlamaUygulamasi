package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.mapper;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto.ReportUpdateDto;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Report;

public class ReportMapperManager {

    public static Report mapReportDtoToReportObject(ReportUpdateDto reportDto, Report report) {

        report.setReportDate(reportDto.getReportDate());
        report.setFolderPath(reportDto.getFolderPath());
        report.setIllnesTitle(reportDto.getIllnesTitle());
        report.setIllnesDescription(reportDto.getIllnesDescription());
        return report;
    }
    public static ReportUpdateDto mapReportToReportObject(Report report){
        ReportUpdateDto reportDto = new ReportUpdateDto();
        reportDto.setId(report.getId());
        reportDto.setReportDate(report.getReportDate());
        reportDto.setIllnesTitle(report.getIllnesTitle());
        reportDto.setIllnesDescription(reportDto.getIllnesDescription());
        reportDto.setFolderPath(reportDto.getFolderPath());
        reportDto.setLaborantId(report.getLaborant().getId());
        reportDto.setPatientId(report.getPatient().getId());
        return  reportDto;
    }
}