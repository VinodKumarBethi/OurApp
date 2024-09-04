package com.example.retailer.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retailer.model.Services;



@Repository
public interface ServicesRepo extends JpaRepository<Services,String>{

    public List<Services> getServicesByRetailerId(String retId);


}
