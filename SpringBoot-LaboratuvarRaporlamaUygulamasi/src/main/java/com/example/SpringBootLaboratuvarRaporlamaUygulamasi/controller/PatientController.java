package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.controller;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public String viewHomePage(Model model){
        return findPagePatient(1, "name", "asc", model);
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
        return "redirect:/patient";
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
        return "redirect:/patient";

    }
    @PostMapping("/showSearchPatient")
    public String showSearchPatient(@ModelAttribute("search") String search, Model model) {
        List<Patient> listPatient = patientService.getSearchPatient(search);
        model.addAttribute("listPatients", listPatient);
        model.addAttribute("search", search);
        model.addAttribute("listPatientSize", listPatient.size());
        return findPagePatient2(1, "name", "asc", search, model);
    }

    @GetMapping("/pagePatient/{pageNo}")
    public String findPagePatient(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
                                @RequestParam("sortDirection") String sortDirection, Model model) {

        int pageSize = 5;

        Page<Patient> page = patientService.findPage(pageNo, pageSize, sortField, sortDirection);
        List<Patient> listPatients = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);

        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");

        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listPatients", listPatients);

        return "patient";
    }

    @GetMapping("/pagePatientNumber/{pageNo}")
    public String findPagePatient2(@PathVariable(value = "pageNo") int pageNo,
                                 @RequestParam("sortField") String sortField, @RequestParam("sortDirection") String sortDirection,
                                 @ModelAttribute("search") String search, Model model) {

        int pageSize = 5;

        Page<Patient> page = patientService.findPage(pageNo, pageSize, sortField, sortDirection);
        List<Patient> listPatients = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);

        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");

        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listPatients", listPatients);

        List<Patient> listPatient = patientService.getSearchPatient(search);
        model.addAttribute("listPatients", listPatient);
        model.addAttribute("search", search);
        model.addAttribute("listPatientSize", listPatient.size());

        return "search_patient";
    }
}
