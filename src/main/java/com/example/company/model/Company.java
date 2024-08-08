package com.example.company.model;

import jakarta.persistence.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int sales;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;  // This is the owning side of the relationship

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Company(Long id, int sales, String name) {
        this.id = id;
        this.sales = sales;
        this.name = name;
    }

    public Company() {
    }
}
