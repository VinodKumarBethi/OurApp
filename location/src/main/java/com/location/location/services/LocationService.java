package com.location.location.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.location.feign.RetailerFeignClient;
import com.location.location.model.Retailer;


@Service
public class LocationService {


    

    @Autowired
    private RetailerFeignClient retailerFeignClient;

    public List<Retailer>  getRetailerList(String id) {
      return retailerFeignClient.getAllRetailersbyLoc(id);
    }



}
