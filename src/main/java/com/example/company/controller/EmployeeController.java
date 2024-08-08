package com.example.company.controller;

import com.example.company.model.Employee;
import com.example.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    EmployeeService employeeService;

    //@Operation(summary = "Get all employees")
    @GetMapping("/getallemployees")
    public Iterable<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @PostMapping("/saveemployee")
    public ResponseEntity<Employee> createEmployee(Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
