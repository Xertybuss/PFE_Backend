package com.example.demo.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.readDtos.CompanyReadDto;
import com.example.demo.dtos.writeUpdateDtos.CompanyWriteDto;
import com.example.demo.mappers.CompanyMapper;
import com.example.demo.services.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PreAuthorize("hasRole('LOGISTICS')")
    @GetMapping("/all")
    public List<CompanyReadDto> getAllCompanies() {
        return CompanyMapper.toDtoList(companyService.getAllCompanies());
    }

    @PreAuthorize("hasRole('LOGISTICS')")
    @GetMapping("/company/{id}")
    public CompanyReadDto getCompanyById(@PathVariable Integer id) {
        return CompanyMapper.toDto(companyService.getCompanyById(id));
    }

    @PreAuthorize("hasRole('LOGISTICS')")
    @PostMapping("/create")
    public CompanyReadDto createCompany(@RequestBody CompanyWriteDto entity) {
        return CompanyMapper.toDto(companyService.createCompany(CompanyMapper.toEntity(entity)));
    }
    
    @PreAuthorize("hasRole('LOGISTICS')")
    @PutMapping("/update")
    public CompanyReadDto updateCompany(@RequestBody CompanyWriteDto entity) {
        return CompanyMapper.toDto(companyService.updateCompany(CompanyMapper.toEntity(entity)));
    }

    @PreAuthorize("hasRole('LOGISTICS')")
    @DeleteMapping("/delete/{id}")
    public void deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
    }
}