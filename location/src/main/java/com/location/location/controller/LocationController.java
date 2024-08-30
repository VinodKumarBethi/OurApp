package com.location.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.location.model.Retailer;
import com.location.location.services.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private  LocationService locationService;

    @GetMapping("/getRetailersByLocId/{id}")
    public List<Retailer>  getRetailersByLocId(@PathVariable String id) {
        return locationService.getRetailerList(id);
    }






}
