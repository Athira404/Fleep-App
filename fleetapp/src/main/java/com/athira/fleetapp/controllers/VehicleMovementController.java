package com.athira.fleetapp.controllers;

import com.athira.fleetapp.entities.VehicleMovement;
import com.athira.fleetapp.services.LocationService;
import com.athira.fleetapp.services.SupplierService;
import com.athira.fleetapp.services.VehicleMovementService;
import com.athira.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMovementController {
    @Autowired
    private VehicleMovementService vehicleMovementService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private VehicleService vehicleService;



    @GetMapping("/vehicleMovements")
    public String getVehicleMovements(Model model) {

        model.addAttribute("vehicleMovements", vehicleMovementService.getVehicleMovements());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("vehicles", vehicleService.getVehicles());

        return "VehicleMovement";
    }

    @PostMapping("/vehicleMovements/addNew")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping("vehicleMovements/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(Integer id) {
        return vehicleMovementService.findById(id);
    }

    @RequestMapping(value="/vehicleMovements/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value="/vehicleMovements/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovements";
    }
}
