package com.example.retailer.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retailer.dto.RetailerDto;
import com.example.retailer.feign.ServicesFeignClient;
import com.example.retailer.model.Retailer;
import com.example.retailer.model.Services;
import com.example.retailer.service.RetailerService;





@RestController
@RequestMapping("/retailer")
public class Controll {

    @Autowired
     private RetailerService retailerService;

    @Autowired
    private ServicesFeignClient servicesFeignClient;

     
     @GetMapping("/allRetailers")
    public ResponseEntity<List<RetailerDto>> getAllRetailers(){
        return ResponseEntity.ok(retailerService.getAllRetailers());
    }

    @GetMapping("/allRetailers/{id}")
    public ResponseEntity<RetailerDto> getAlCusts(@PathVariable String id){
        return ResponseEntity.ok(retailerService.getRetailerByID(id));
    }

    @GetMapping("/retailersByLocId/{locationId}")
    public ResponseEntity<List<RetailerDto>> getAllRetailersbyLoc(@PathVariable String locationId){
        return ResponseEntity.ok(retailerService.getRetailersByLocation(locationId));
    }

    @PostMapping("/saveRetailer")
    public boolean saveRetailer(@RequestBody Retailer r){
        return retailerService.saveRetailer(r);
    }

    @PutMapping("/updateRetailer")
    public boolean updateRetailer(@RequestBody Retailer r){        
        return retailerService.updateRetailer(r);
    }

    @GetMapping("/getRetailerByName/{name}")
    public ResponseEntity<List<RetailerDto>> getRetailerByName(@PathVariable String name){
        return ResponseEntity.ok(retailerService.getByRetailerName(name));
    }

    @GetMapping("/getRetailerByUserName/{uname}")
    public ResponseEntity<RetailerDto> getRetailerByUserName(@PathVariable String uname){
        return ResponseEntity.ok(retailerService.getByRetailerUserName(uname));
    }
    

    @GetMapping("/feign/{id}")
    public List<Services> getServices(@PathVariable String id){
        return servicesFeignClient.getServicesByRetailerId(id);
    }
}
