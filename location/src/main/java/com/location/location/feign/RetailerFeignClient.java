package com.location.location.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.location.location.model.Retailer;

@FeignClient(name = "retailerClient",url = "http://localhost:8181/retailer")
public interface RetailerFeignClient {

    @GetMapping("/retailersByLocId/{locationId}")
    public List<Retailer> getAllRetailersbyLoc(@PathVariable String locationId);
}
