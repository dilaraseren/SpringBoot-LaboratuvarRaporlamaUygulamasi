package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.controller;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.User;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.concretes.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserManager userManager;


    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user ) {
        User oauthUser = userManager.login(user.getUsername(), user.getPassword());
        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {
            return "redirect:/home";

        } else {
            return "redirect:/login";
        }

    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {
        return "redirect:/login";
    }


}
