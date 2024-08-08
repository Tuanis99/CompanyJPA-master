package com.example.company.controller;

import com.example.company.model.Company;
import com.example.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    CompanyService companyService;

    @GetMapping("/getallcompanies")
    public Iterable<Company> getAllCompanies(){
        return companyService.findAll();
    }

    @GetMapping("/getallcompanies/order")
    public Iterable<Company> findAllByOrderBySales(){
        return companyService.findAllByOrderBySales();
    }

    @GetMapping("/ordergreater/{sales}")
    public Iterable<Company> findAllBySalesGreaterThanEqual(@PathVariable int sales){
        return companyService.findAllBySalesGreaterThanEqual(sales);
    }

    @GetMapping("/findbyname/{name}")
    public Iterable<Company> findByName(@PathVariable String name){
        return companyService.findByName(name);
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }
}
