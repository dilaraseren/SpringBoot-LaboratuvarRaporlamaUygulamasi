package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service;


import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Report;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService  {

    @Autowired
    private ReportRepository reportRepository;



    public List<Report> getAllReport() {
        return this.reportRepository.findAllReport();
    }


    public List<Report> listDateReport() {
        return this.reportRepository.listDateReport();
    }



    public Report saveReports(Report report) {
        System.out.println("report: "+report);

        return reportRepository.save(report);
    }


    public Report getReportById(long id) {
        Optional<Report> optional = reportRepository.findById(id);
        Report report = null;
        if (optional.isPresent()) {
            report = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return report;
    }


    public void deleteReportById(long id) {
        this.reportRepository.deleteReportById(id);
    }
}