package com.example.TableService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TableService.model.TableRAH;
import com.example.TableService.repo.RAHRepo;
import com.example.TableService.services.RAHService;
import java.util.List;

@RestController
public class RAHController {

   @Autowired
   RAHService rahService;

//    @Autowired
//    RAHRepo rahRepo;

    @GetMapping("/getcustByid/{id}")
    public TableRAH getCust(@PathVariable String id){
        return rahService.getRAHByCustomer(id);
    }

    @PutMapping("/updateServiceStatus/{reqId}/{status}")
    public boolean  updateServiceStatus(@PathVariable String reqId,@PathVariable String status){
        return rahService.updateOngoingStatus(reqId, status);
    }

    @DeleteMapping("/withDrawRequest/{reqId}")
    public boolean  withdrawRequest(@PathVariable String reqId){
        return rahService.withdrawalRequest(reqId);
    }


    @PostMapping("/setmessage")
    public boolean setMessage(@RequestBody TableRAH r){
        return rahService.setRetMessage(r.getRequestId(), r.getRetailerMessage());

    }


    // @GetMapping("/getById/{id}")
    // public TableRAH getRahById(@PathVariable String id){
    //     return rahRepo.findByRequestId(id);
    // }

    @GetMapping("/getRequestByRetIdAndApprovalStatus/{id}")
    public List<TableRAH>  getRequestByRetIdAndApprovalStatus(@PathVariable String id){
        return rahService.getRequestByRetIdAndApprovalStatus(id);
    }



}
