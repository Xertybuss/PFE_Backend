package com.example.demo.mappers;

import org.springframework.beans.BeanUtils;

import com.example.demo.dtos.readDtos.CompanyReadDto;
import com.example.demo.dtos.writeUpdateDtos.CompanyWriteDto;
import com.example.demo.entities.Company;

public class CompanyMapper {
    public static Company toEntity(CompanyWriteDto companyWriteDto){
        if(companyWriteDto == null) return null;
        Company company = new Company();
        BeanUtils.copyProperties(companyWriteDto, company);
        return company;
    }

    public static CompanyReadDto toDto(Company company){
        if(company == null) return null;
        CompanyReadDto companyReadDto = new CompanyReadDto();
        BeanUtils.copyProperties(company, companyReadDto);
        return companyReadDto;
    }
}
