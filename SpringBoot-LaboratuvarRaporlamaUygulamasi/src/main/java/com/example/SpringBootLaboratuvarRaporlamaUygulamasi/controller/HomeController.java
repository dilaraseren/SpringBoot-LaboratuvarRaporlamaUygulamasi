package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/not-auth")
    public String getAccessDenied() {
        return "/not-auth";
    }
}
