package com.example.retailer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.retailer.model.Services;
import com.example.retailer.service.RetServices;



@RestController
@RequestMapping("/retailerservices")
public class ServicesController {

    @Autowired
    private RetServices retServices;

    @GetMapping("/getServicesByRetId/{retId}")
    public List<Services> getServicesByRetId(@PathVariable String retId) {
        return retServices.getServicesByRetId(retId);
    }


}
