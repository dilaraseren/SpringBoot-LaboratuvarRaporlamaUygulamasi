package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.controller;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto.ReportDto;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Report;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.ReportRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "redirect:/";
    }

}
