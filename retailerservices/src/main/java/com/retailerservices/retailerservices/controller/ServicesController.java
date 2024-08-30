package com.retailerservices.retailerservices.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.retailerservices.retailerservices.model.Services;
import com.retailerservices.retailerservices.services.RetServices;

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
