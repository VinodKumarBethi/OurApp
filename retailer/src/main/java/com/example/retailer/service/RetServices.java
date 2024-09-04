package com.example.retailer.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailer.model.Services;
import com.example.retailer.repo.ServicesRepo;


@Service
public class RetServices {

    @Autowired
    private ServicesRepo servicesRepo;

    public List<Services> getServicesByRetId(String retId){
        return servicesRepo.getServicesByRetailerId(retId);
    }

}
