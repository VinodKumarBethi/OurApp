package com.retailerservices.retailerservices.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailerservices.retailerservices.model.Services;

@Repository
public interface ServicesRepo extends JpaRepository<Services,String>{

    public List<Services> getServicesByRetailerId(String retId);


}
