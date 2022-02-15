package com.athira.fleetapp.controllers;

import com.athira.fleetapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/profile")
    public String profile(Model model, Principal principal) {
//        get the current logged in employee to the model --> principal
        String username = principal.getName(); //get logged in userName
        model.addAttribute("employee", employeeService.findByUsername(username));
        return "profile";
    }
}
