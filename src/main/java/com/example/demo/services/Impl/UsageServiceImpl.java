package com.example.demo.services.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Usage;
import com.example.demo.repositories.UsageRepository;
import com.example.demo.services.UsageService;

@Service
public class UsageServiceImpl implements UsageService{
    private UsageRepository usageRepository;

    public UsageServiceImpl(UsageRepository usageRepository){
        this.usageRepository = usageRepository;
    }

    @Override
    public List<Usage> getAllUsages() {
        return usageRepository.findAll();
    }

    @Override
    public Usage getUsageById(Integer id) {
        return usageRepository.findUsageById(id);
    }

    @Override
    public Usage createUsage(Usage usage) {
        return usageRepository.save(usage);
    }

    @Override
    public Usage updateUsage(Usage usage) {
        Usage existingUsage = usageRepository.findUsageById(usage.getId());
        BeanUtils.copyProperties(usage, existingUsage, "id");
        return usageRepository.save(existingUsage);
    }

    @Override
    public void deleteUsage(Integer id) {
        usageRepository.deleteById(id);
    }

    
}
