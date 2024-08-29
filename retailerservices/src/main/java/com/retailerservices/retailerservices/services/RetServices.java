package com.retailerservices.retailerservices.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailerservices.retailerservices.model.Services;
import com.retailerservices.retailerservices.repo.ServicesRepo;

@Service
public class RetServices {

    @Autowired
    private ServicesRepo servicesRepo;

    public List<Services> getServicesByRetId(String retId){
        return servicesRepo.getServicesByRetailerId(retId);
    }

}
