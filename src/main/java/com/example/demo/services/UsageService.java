package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Usage;

public interface UsageService {
    public List<Usage> getAllUsages();
    public Usage getUsageById(Integer id);
    public Usage createUsage(Usage usage);
    public Usage updateUsage(Usage usage);
    public void deleteUsage(Integer id);
}
