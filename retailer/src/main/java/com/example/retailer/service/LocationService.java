package com.example.retailer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailer.model.Retailer;
import com.example.retailer.repo.RetailerRepo;




@Service
public class LocationService {


    @Autowired
    private RetailerRepo repo;


    public List<Retailer>  getRetailerList(String id) {
      
      return repo.getByRetailerLocationId(id);
    }



}
