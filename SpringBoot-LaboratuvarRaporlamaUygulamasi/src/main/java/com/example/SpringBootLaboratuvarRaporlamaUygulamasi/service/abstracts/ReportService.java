package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto.ReportDto;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Report;

import java.util.List;

public interface ReportService {
    List<Report> getAllReports();
    List<Report> listDateReport();
    Report saveReports(ReportDto reportDto);

    Report getReportById(long id);
    void deleteReportById(long id);
}
