package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.controller;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listPatients",patientService.getAllPatients());
        return "patient";
    }

    @GetMapping("/showNewPatientForm")
    public String showNewPatientForm(Model model){
        Patient patient= new Patient();
        model.addAttribute("patient",patient);
        return "new_patient";
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("patient") Patient patient){
        patientService.savePatients(patient);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){

        Patient patient= patientService.getPatientById(id);
        model.addAttribute("patient",patient);
        return "update_patient";

    }
    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") long id){
        this.patientService.deletePatientById(id);
        return "redirect:/";

    }
}
