package com.example.streets.service;


import com.example.streets.entity.District;
import com.example.streets.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    public Iterable<District> findAll(){
        return districtRepository.findAll();
    }

    public Optional<District> findById(String id){
        return districtRepository.findById(id);
    }
    public District save(District district){
        return districtRepository.save(district);
    }
}
