package com.example.company.service;
import com.example.company.model.Company;

public interface CompanyService {
    public Iterable<Company> findAll();
    public Iterable<Company> findByName(String name);
    public Iterable<Company> findAllByOrderBySales();
    public Iterable<Company> findAllBySalesGreaterThanEqual(int sales);
    public Company saveCompany(Company company);
}
