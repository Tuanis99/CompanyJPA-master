package com.example.company.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String name;
    int salary;

    @OneToMany(mappedBy = "employee")
    List<Company> companyList= new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
