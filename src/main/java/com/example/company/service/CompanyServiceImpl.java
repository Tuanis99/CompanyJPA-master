package com.example.company.service;

import com.example.company.dataaccess.CompanyRepository;
import com.example.company.dataaccess.EmployeeRepository;
import com.example.company.model.Company;
import com.example.company.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{
    CompanyRepository companyRepository;
    EmployeeRepository employeeRepository;


    @Override
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Iterable<Company> findByName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public Iterable<Company> findAllByOrderBySales() {
        return companyRepository.findAllByOrderBySales();
    }

    @Override
    public Iterable<Company> findAllBySalesGreaterThanEqual(int sales) {
        return companyRepository.findAllBySalesGreaterThanEqual(sales);
    }

    @Override
    public Company saveCompany(Company company){
        Employee employee = new Employee();
        Optional<Employee> employeeOptional = employeeRepository.findByName(employee.getName());

        if(employeeOptional.isPresent()){
            employee = employeeOptional.get();
        } else {
            Employee realEmployee = new Employee();
            realEmployee.setName(employee.getName());
            employee = employeeRepository.save(realEmployee);
        }
        company.setEmployee(employee);
        return companyRepository.save(company);
    }

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
}
