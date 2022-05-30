package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.concretes;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto.ReportDto;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Image;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Report;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.ImageRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.LaborantRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.PatientRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.ReportRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.ImageService;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.LaborantService;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.PatientService;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReportManager implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private LaborantRepository laborantRepository;

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public List<Report> getAllReports() {
        return this.reportRepository.findAllReport();
    }

    @Override
    public List<Report> listDateReport() {
        return this.reportRepository.listDateReport();
    }


    @Override
    public Report saveReports(Report report) {
        System.out.println("report: "+report);

        return reportRepository.save(report);
    }

    @Override
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

    @Override
    public void deleteReportById(long id) {
        this.reportRepository.deleteReportById(id);
    }
}