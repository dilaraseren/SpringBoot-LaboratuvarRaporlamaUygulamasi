package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.controller;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.LaborantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LaborantController {

    @Autowired
    private LaborantService laborantService;

    @GetMapping("/laborant")
    public String viewHomePage(Model model){
        return findPageLaborant(1, "name", "asc", model);
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
        return "update_laborant"; //burayı düzelt

    }
    @GetMapping("/deleteLaborant/{id}")
    public String deleteLaborant(@PathVariable(value = "id") long id){
        this.laborantService.deleteLaborantById(id);
        return "redirect:/laborant";

    }


    @PostMapping("/showSearchLaborant")
    public String showSearchLaborant(@ModelAttribute("search") String search, Model model) {
        List<Laborant> listLaborant = laborantService.getSearchLaborant(search);
        model.addAttribute("listLaborants", listLaborant);
        model.addAttribute("search", search);
        model.addAttribute("listLaborantSize", listLaborant.size());
        return findPageLaborant2(1, "name", "asc", search, model);
    }

    @GetMapping("/pageLaborant/{pageNo}")
    public String findPageLaborant(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
                                @RequestParam("sortDirection") String sortDirection, Model model) {

        int pageSize = 5;

        Page<Laborant> page = laborantService.findPage(pageNo, pageSize, sortField, sortDirection);
        List<Laborant> listLaborants = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);

        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");

        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listLaborants", listLaborants);

        return "laborant";
    }

    @GetMapping("/pageLaborantNumber/{pageNo}")
    public String findPageLaborant2(@PathVariable(value = "pageNo") int pageNo,
                                 @RequestParam("sortField") String sortField, @RequestParam("sortDirection") String sortDirection,
                                 @ModelAttribute("search") String search, Model model) {

        int pageSize = 5;

        Page<Laborant> page = laborantService.findPage(pageNo, pageSize, sortField, sortDirection);
        List<Laborant> listLaborants = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);

        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");

        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listLaborants", listLaborants);

        List<Laborant> listLaborant = laborantService.getSearchLaborant(search);
        model.addAttribute("listLaborants", listLaborant);
        model.addAttribute("search", search);
        model.addAttribute("listLaborantSize", listLaborant.size());

        return "search_laborant";
    }


}
