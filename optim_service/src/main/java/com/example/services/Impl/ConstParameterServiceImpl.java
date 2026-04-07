package com.example.services.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.entities.ConstParameter;
import com.example.repositories.ConstParameterRepository;
import com.example.services.ConstParameterService;

@Service
public class ConstParameterServiceImpl implements ConstParameterService{
    private ConstParameterRepository constParameterRepository;

    public ConstParameterServiceImpl(ConstParameterRepository constParameterRepository){
        this.constParameterRepository = constParameterRepository;
    }

    @Override
    public ConstParameter getConstParameterById(Integer id) {
        return constParameterRepository.findConstParameterById(id);
    }

    @Override
    public List<ConstParameter> getAllConstParameters() {
        return constParameterRepository.findAll();
    }

    @Override
    public ConstParameter createConstParameter(ConstParameter constParameter) {
        return constParameterRepository.save(constParameter);
    }

    @Override
    public ConstParameter updateConstParameter(ConstParameter constParameter) {
        ConstParameter existingConstParameter = constParameterRepository.findConstParameterById(constParameter.getId());
        BeanUtils.copyProperties(constParameter, existingConstParameter, "id");
        return constParameterRepository.save(existingConstParameter);
    }

    @Override
    public void deleteConstParameter(Integer id) {
        constParameterRepository.deleteById(id);
    }

    
}
