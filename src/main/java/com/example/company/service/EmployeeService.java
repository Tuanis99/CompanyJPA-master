package com.example.company.service;

import com.example.company.model.Employee;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public Iterable<Employee> findAllEmployees();
}
