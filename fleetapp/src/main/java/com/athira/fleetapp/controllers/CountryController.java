package com.athira.fleetapp.controllers;

import com.athira.fleetapp.EntityNotFoundException;
import com.athira.fleetapp.entities.Country;
import com.athira.fleetapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getCountries(Model model){
        //to pass something across html we need model. Here we are passing countryList to country.html
        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);//passing/placing countryList into model obj
        return "Country";
    }

    @PostMapping("/countries/addNew")//coming from the form in country html
    public String addNewCountry(Country country){
        countryService.saveCountry(country);
        return "redirect:/countries";
    }

    @RequestMapping("/countries/findById")
    @ResponseBody
    public Country findById(int id){
        return countryService.findById(id);
    }

    @RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateCountry(Country country, Model model){
        countryService.saveCountry(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteCountry(int id){
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }


}
