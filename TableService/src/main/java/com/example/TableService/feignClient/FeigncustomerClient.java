package com.example.TableService.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.TableService.model.Customer;

@FeignClient(value ="customerClient",url = "http://localhost:8082")
public interface FeigncustomerClient {

    @GetMapping("/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable("id") String id);

}
