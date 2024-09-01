package com.example.TableService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.TableService.model.TableRAH;
import com.example.TableService.services.RAHService;

@RestController
public class RAHController {

   @Autowired
   RAHService rahService;

    @GetMapping("/getcustByid/{id}")
    public TableRAH getCust(@PathVariable String id){
        return rahService.getRAHByCustomer(id);
    }

}
