package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.controller;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto.ReportDto;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto.ReportUpdateDto;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.mapper.ReportMapperManager;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Report;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.ReportRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/report")
    public String viewHomePage(Model model){
        model.addAttribute("listReports",reportService.getAllReports());
        return "report";
    }

    @GetMapping("/showNewReportForm")
    public String showNewReportForm(Model model){
        ReportDto reportDto= new ReportDto();
        model.addAttribute("report",reportDto);
        return "new_report";
    }

    @PostMapping("/saveReport")
    public String saveReport(@ModelAttribute("report") ReportDto reportDto){
        reportService.saveReports(reportDto);
        return "redirect:/report";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Report report = reportService.getReportById(id);
        model.addAttribute("reportDto", ReportMapperManager.mapReportToReportObject(report));
        return "update-report";
    }
    @PostMapping("/update/{id}")
    public String updateReport(@PathVariable("id") long id, @Valid ReportUpdateDto reportDto, BindingResult result, Model model) {

        Report report = reportService.getReportById(id);
        reportRepository.save(ReportMapperManager.mapReportDtoToReportObject(reportDto,report));
        return "report";
    }

    @GetMapping("deleteReportById")
    public String deleteReportById(@PathVariable("reportid") long reportId){
        this.reportService.deleteReportById(reportId);
        return "redirect:/report";
    }
}
