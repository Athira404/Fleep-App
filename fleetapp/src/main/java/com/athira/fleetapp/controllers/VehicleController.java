package com.athira.fleetapp.controllers;

import com.athira.fleetapp.entities.Vehicle;
import com.athira.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VehicleStatusService vehicleStatusService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private VehicleModelService vehicleModelService;


    @GetMapping("/vehicles")
    public String getVehicles(Model model) {

        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuses());
        model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
        model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());

        return "Vehicle";
    }

    @PostMapping("/vehicles/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(Integer id) {
        return vehicleService.findById(id);
    }

    @RequestMapping(value="/vehicles/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value="/vehicles/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}
