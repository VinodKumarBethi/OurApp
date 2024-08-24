package com.example.demo.contr;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.RetailerDto;
import com.example.demo.model.Retailer;
import com.example.demo.services.RetailerService;


@RestController
public class Controll {

    @Autowired
     private RetailerService retailerService;
     
     @GetMapping("/allRetailers")
    public ResponseEntity<List<RetailerDto>> getAllRetailers(){
        return ResponseEntity.ok(retailerService.getAllRetailers());
    }

    @GetMapping("/allRetailers/{id}")
    public ResponseEntity<RetailerDto> getAlCusts(@PathVariable String id){
        return ResponseEntity.ok(retailerService.getRetailerByID(id));
    }

    @GetMapping("/retailersById/{locationId}")
    public ResponseEntity<List<RetailerDto>> getAllRetailersbyLoc(@PathVariable String locationId){
        return ResponseEntity.ok(retailerService.getRetailersByLocation(locationId));
    }

    @PostMapping("/saveRetailer")
    public boolean saveRetailer(@RequestBody Retailer r){
        return retailerService.saveRetailer(r);
    }

    @PutMapping("/updateRetailer")
    public boolean updateRetailer(@RequestBody Retailer r){        
        return retailerService.updateRetailer(r);
    }

    @GetMapping("/getRetailerByName/{name}")
    public ResponseEntity<List<RetailerDto>> getRetailerByName(@PathVariable String name){
        return ResponseEntity.ok(retailerService.getByRetailerName(name));
    }

    @GetMapping("/getRetailerByUserName/{uname}")
    public ResponseEntity<RetailerDto> getRetailerByUserName(@PathVariable String uname){
        return ResponseEntity.ok(retailerService.getByRetailerUserName(uname));
    }
    

    @GetMapping("/test/{token}")
    public RetailerDto test(@PathVariable String token){
        return retailerService.getProfile(token);
    }


    @GetMapping("/test2")
    public RetailerDto test2(@RequestHeader("Authorization") String bearerToken){

        String token= bearerToken.substring(7);
    return retailerService.getProfile(token);
    }

}
