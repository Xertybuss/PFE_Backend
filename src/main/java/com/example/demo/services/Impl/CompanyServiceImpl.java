package com.example.demo.services.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Company;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Integer id) {
        return companyRepository.findCompanyById(id);
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        Company existingCompany = companyRepository.findCompanyById(company.getId());
        BeanUtils.copyProperties(company, existingCompany, "id");
        return companyRepository.save(existingCompany);
    }

    @Override
    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }
}
