package com.example.demo.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;

import com.example.demo.dtos.readDtos.CompanyReadDto;
import com.example.demo.dtos.writeUpdateDtos.CompanyWriteDto;
import com.example.demo.entities.Company;

@Mapper
public class CompanyMapper {
    public static Company toEntity(CompanyWriteDto companyWriteDto){
        if (companyWriteDto == null) return null;
        Company company = new Company();
        BeanUtils.copyProperties(companyWriteDto, company, "id");
        return company;
    }

    public static CompanyReadDto toDto(Company company){
        if (company == null) return null;
        return new CompanyReadDto(
            company.getId(),
            company.getCodeCompany(),
            company.getLabel(),
            company.getAddress(),
            company.getPhoneNumber(),
            VehicleMapper.toDtoList(company.getVehicles()),
            AccountUserMapper.toDtoList(company.getAccounts()),
            CollaboraterMapper.toDtoList(company.getCollaboraters())
        );
    }

    public static List<CompanyReadDto> toDtoList(List<Company> companies){
        if (companies == null) return null;
        return companies.stream().map(CompanyMapper::toDto).toList();
    }
}
