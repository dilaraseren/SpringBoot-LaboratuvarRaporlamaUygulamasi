package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.controller;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.LaborantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LaborantController {

    @Autowired
    private LaborantService laborantService;

    @GetMapping("/laborant")
    public String viewHomePage(Model model){
        model.addAttribute("listLaborants",laborantService.getAllLaborants());
        return "laborant";
    }

    @GetMapping("/showNewLaborantForm")
    public String showNewLaborantForm(Model model){
        Laborant laborant= new Laborant();
        model.addAttribute("laborant",laborant);
        return "new_laborant";
    }

    @PostMapping("/saveLaborant")
    public String saveLaborant(@ModelAttribute("laborant") Laborant laborant){
        laborantService.saveLaborants(laborant);
        return "redirect:/laborant";
    }

    @GetMapping("/showFormForUpdateLaborant/{id}")
    public String showFormForUpdateLaborant(@PathVariable(value = "id") long id, Model model){
        Laborant laborant= laborantService.getLaborantById(id);
        model.addAttribute("laborant",laborant);
        return "update_laborant";

    }
    @GetMapping("/deleteLaborant/{id}")
    public String deleteLaborant(@PathVariable(value = "id") long id){
        this.laborantService.deleteLaborantById(id);
        return "redirect:/laborant";

    }
}
