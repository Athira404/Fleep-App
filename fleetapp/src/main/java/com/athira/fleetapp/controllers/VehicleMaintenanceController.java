package com.athira.fleetapp.controllers;

import com.athira.fleetapp.entities.VehicleMaintenance;
import com.athira.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMaintenanceController {
    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private VehicleService vehicleService;



    @GetMapping("/vehicleMaintenances")
    public String getVehicleMaintenances(Model model) {

        model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenances());
        model.addAttribute("suppliers", supplierService.getSuppliers());
        model.addAttribute("vehicles", vehicleService.getVehicles());

        return "VehicleMaintenance";
    }

    @PostMapping("/vehicleMaintenances/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping("vehicleMaintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(Integer id) {
        return vehicleMaintenanceService.findById(id);
    }

    @RequestMapping(value="/vehicleMaintenances/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping(value="/vehicleMaintenances/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenances";
    }
}
