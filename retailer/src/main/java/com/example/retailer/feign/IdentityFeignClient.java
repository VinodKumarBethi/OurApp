package com.example.retailer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.retailer.model.UserCredential;

@FeignClient(name = "identityClient" ,url="http://localhost:8086/auth")
public interface IdentityFeignClient {

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user);

}
