package com.athira.fleetapp.services;

import com.athira.fleetapp.entities.Employee;
import com.athira.fleetapp.entities.Employee;
import com.athira.fleetapp.entities.User;
import com.athira.fleetapp.repositories.EmployeeRepository;
import com.athira.fleetapp.repositories.EmployeeRepository;
import com.athira.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }


    public Employee findByUsername(String userName) {
        return employeeRepository.findByUsername(userName);
    }


//    //Set the Username of the employee where username match
//    public void assignUsername(int id) {
//        Employee employee = employeeRepository.findById(id).orElse(null);
//        User user = userRepository.findByUsername(employee.getUsername());
//        employee.setUsername(user.getUsername());
//        employeeRepository.save(employee);
//    }
}
