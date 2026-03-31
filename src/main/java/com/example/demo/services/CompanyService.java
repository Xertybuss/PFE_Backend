package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Company;

public interface CompanyService {
    public List<Company> getAllCompanies();
    public Company getCompanyById(Integer id);
    public Company createCompany(Company company);
    public Company updateCompany(Company company);
    public void deleteCompany(Integer id);
}
