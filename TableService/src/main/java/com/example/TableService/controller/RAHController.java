package com.example.TableService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.TableService.model.TableRAH;
import com.example.TableService.services.RAHService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RAHController {

   @Autowired
   RAHService rahService;

    @GetMapping("/getRequestsByRetailerId/{id}")
    public ResponseEntity<List<TableRAH>> getRequestsByRetailerId(@PathVariable String id){
        return ResponseEntity.ok( rahService.getRAHQueueByRetailer(id));
    }
    @PostMapping("/createRequest")
    public ResponseEntity<TableRAH> createRequest(@RequestBody TableRAH tableRAH) {        
        return ResponseEntity.ok(rahService.createRAH(tableRAH));
    }
    @GetMapping("/getAllRequestsByCustId/{custId}")
    public ResponseEntity<List<TableRAH>> getRequestByCustId(@PathVariable String custId) {
        return ResponseEntity.ok(rahService.getRAHByCustomer(custId));
        
    }

    @PostMapping("/updateRequestApproval")
    public ResponseEntity<TableRAH> updateRequestApproval(@RequestBody TableRAH updates) {
        return ResponseEntity.ok(rahService.updateApproveOrReject(updates.getRequestId(), updates.getRetId(), updates.isAccepted()));
    }

    @GetMapping("/getCurrentCustomerRequest/{custId}")
    public ResponseEntity<TableRAH> getCurrentCustomerRequest(@PathVariable String custId) {
        System.out.println("efcsac Controller here: " +custId);

        return ResponseEntity.ok(rahService.getCurrentRequestByCustomer(custId));
    }
    
     

}
