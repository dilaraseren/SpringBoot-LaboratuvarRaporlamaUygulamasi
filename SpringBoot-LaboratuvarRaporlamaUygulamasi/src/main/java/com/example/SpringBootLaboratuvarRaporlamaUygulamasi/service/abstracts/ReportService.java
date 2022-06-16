package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Report;

import java.util.List;

public interface ReportService {
    List<Report> getAllReport();
    List<Report> listDateReport();
    Report saveReports(Report report);
    Report getReportById(long id);
    void deleteReportById(long id);
}
