package com.example.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.app.model.UserCredential;

@FeignClient(name = "identityclient", url = "http://localhost:8086/auth")
public interface IdentityFeignClient {
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user);
}
