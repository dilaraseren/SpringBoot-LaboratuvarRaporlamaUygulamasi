package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.concretes;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto.ReportDto;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Report;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.ReportRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.LaborantService;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.PatientService;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReportManager implements ReportService
{

    @Autowired
    private ReportRepository reportRepository ;

    @Autowired
    private PatientService patientService;

    @Autowired
    private LaborantService laborantService;


    @Override
    public List<Report> getAllReports() {
        return this.reportRepository.findAllReport();
    }

    @Override
    public List<Report> listDateReport() {
        return this.reportRepository.listDateReport();
    }

    @Override
    public Report saveReports(ReportDto reportDto) {
        Report report = new Report();
        Patient patient = this.patientService.getPatientById(reportDto.getPatientId());
        Laborant laborant = this.laborantService.getLaborantById(reportDto.getLaborantId());

        if (patient != null && laborant != null) {
            report.setReportDate(reportDto.getReportDate());
            report.setIllnesTitle(reportDto.getIllnesTitle());
            report.setLaborant(laborant);
            report.setReportNumber(reportDto.getReportNumber());
            report.setPatient(patient);
            report.setIllnesDescription(reportDto.getIllnesDescription());
            report.setFolderPath(reportDto.getFolderPath());
        } else {
            return null;
        }
        return this.reportRepository.save(report);
    }

    @Override
    public Report getReportById(long id) {
        Optional<Report> optional=reportRepository.findById(id);
        Report report=null;
        if (optional.isPresent()){
            report=optional.get();
        }
        else{
            throw new RuntimeException("Employee not found for id :: "+id);
        }
        return report;
    }


    @Override
    public void deleteReportById(long id) {
      this.reportRepository.deleteReportById(id);
    }
}
