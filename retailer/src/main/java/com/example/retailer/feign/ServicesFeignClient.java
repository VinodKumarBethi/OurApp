package com.example.retailer.feign;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.retailer.model.Services;



@FeignClient(name="servicesClient",url="http://localhost:8282")
public interface ServicesFeignClient {

    @GetMapping("/getServicesByRetId/{retId}")
    List<Services>  getServicesByRetailerId(@PathVariable String retId);



}
