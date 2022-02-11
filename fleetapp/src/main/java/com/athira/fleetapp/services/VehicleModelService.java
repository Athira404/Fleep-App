package com.athira.fleetapp.services;

import com.athira.fleetapp.entities.VehicleModel;
import com.athira.fleetapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> getVehicleModels(){
        return vehicleModelRepository.findAll();
    }

    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    public Optional<VehicleModel> findById(int id) {
        return vehicleModelRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
