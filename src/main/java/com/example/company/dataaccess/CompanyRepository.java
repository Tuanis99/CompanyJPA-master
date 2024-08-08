package com.example.company.dataaccess;
import com.example.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
Iterable<Company> findByName(String name);
Iterable<Company> findAllByOrderBySales();
Iterable<Company> findAllBySalesGreaterThanEqual(int sales);

}
