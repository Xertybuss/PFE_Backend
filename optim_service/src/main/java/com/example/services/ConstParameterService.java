package com.example.services;

import java.util.List;

import com.example.entities.ConstParameter;

public interface ConstParameterService {
    public ConstParameter getConstParameterById(Integer id);
    public List<ConstParameter> getAllConstParameters();
    public ConstParameter createConstParameter(ConstParameter constParameter);
    public ConstParameter updateConstParameter(ConstParameter constParameter);
    public void deleteConstParameter(Integer id);
}
