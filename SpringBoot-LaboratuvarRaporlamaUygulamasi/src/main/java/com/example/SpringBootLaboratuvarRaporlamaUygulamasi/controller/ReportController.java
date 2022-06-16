package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.controller;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Report;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.ReportRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/report")
    public String viewHomePage(Model model){
        model.addAttribute("listReports",reportService.getAllReport());
        return "report";
    }

    @GetMapping("/showNewReportForm")
    public String showNewReportForm(Model model){
        Report report= new Report();
        model.addAttribute("report",report);
        return "new_report";
    }
    @PostMapping("/saveReport")
    public String saveReport(@ModelAttribute("report") Report report){
        reportService.saveReports(report);
        return "redirect:/report";
    }

    @GetMapping("/showFormForUpdateReport/{id}")
    public String showFormForUpdateReport(@PathVariable(value = "id") long id, Model model){

        Report report= reportService.getReportById(id);
        model.addAttribute("report",report);
        return "update_report";

    }


    @GetMapping("/deleteReport/{id}")
    public String deleteReport(@PathVariable(value = "id") long id){
        this.reportService.deleteReportById(id);
        return "redirect:/report";

    }


}
