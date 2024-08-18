package com.example.demo.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.customexception.NotFoundException;
import com.example.demo.model.Retailer;
import com.example.demo.repo.RetailerRepo;

@Service
public class RetailerService {

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    @Autowired
    private RetailerRepo retailerRepo;

    public List<Retailer> getAllRetailers(){
       return retailerRepo.findAll();
    }

    public Retailer getRetailerByID(String id){
        return retailerRepo.getByRetailerId(id).orElseThrow(()->new NotFoundException("Retailer with id"+id+"Not Found "));
    }

    public boolean saveRetailer(Retailer r){
        Optional<Retailer> existingRetailer = retailerRepo.getByRetailerId(r.getRetailerId());
        if (existingRetailer.isPresent()) {
            throw new RuntimeException("Customer Already Exists");
        }

        String[] Mandatory_Retailer_Feilds = { r.getRetailerName(), r.getRetailerOwner(), r.getRetailerUsername(), r.getRetailerPass() };
        for (String feild : Mandatory_Retailer_Feilds) {

            if (isNullOrEmpty(feild)) {
                throw new NullPointerException("name, username, password cannot be null");
            }
        }
        r.setRetailerId(UUID.randomUUID().toString());
       Retailer ret= retailerRepo.save(r);
       if(ret.getRetailerId()!=null){
        return true;
       }
       else
       return false;
    }

    public boolean updateRetailer(Retailer r)
    {
        Retailer existingRetailer;

        if (r.getRetailerId() != null && !r.getRetailerId().trim().isEmpty()) {
            existingRetailer = retailerRepo.getByRetailerId(r.getRetailerId())
                    .orElseThrow(() -> new NotFoundException("Retailer with id"+r.getRetailerId()+"Not Found "));
        }  else {
            throw new RuntimeException("Either id or username must be provided");
        }

        if (r.getRetailerName() != null) {
            existingRetailer.setRetailerName(r.getRetailerName());
        }
        if (r.getRetailerEmail() != null) {
            existingRetailer.setRetailerEmail(r.getRetailerEmail());
        }
        if (r.getRetailerMobile() != null) {
            existingRetailer.setRetailerMobile(r.getRetailerMobile());
        }
        if (r.getRetailerOwner() != null) {
            existingRetailer.setRetailerOwner(r.getRetailerOwner());
        }
        
        if (r.getRetailImage()!= null) {
            existingRetailer.setRetailImage(r.getRetailImage());
        }
        if (r.getRetailerPass() != null) {
            existingRetailer.setRetailerPass(r.getRetailerPass());
        }
        if (r.getRetailerDescription() != null) {
            existingRetailer.setRetailerDescription(r.getRetailerDescription());
        }
        if (r.getIsAvailable() != null) {
            existingRetailer.setIsAvailable(r.getIsAvailable());
        }
        if (r.getReatilerAddress() != null) {
            existingRetailer.setReatilerAddress(r.getReatilerAddress());
        }
        if (r.getNoOfBarbers() != null) {
            existingRetailer.setNoOfBarbers(r.getNoOfBarbers());
        }
        if (r.getTimings() != null) {
            existingRetailer.setTimings(r.getTimings());
        }
        

        if ((r.getRetailerName() == null || r.getRetailerName().trim().isEmpty()) &&
                (r.getRetailerEmail() == null || r.getRetailerEmail().trim().isEmpty()) &&
                (r.getRetailerMobile() == null || r.getRetailerMobile().trim().isEmpty()) &&
                (r.getRetailerOwner() == null || r.getRetailerOwner().trim().isEmpty()) &&
                (r.getRetailImage() == null || r.getRetailImage().trim().isEmpty()) &&
                (r.getRetailerPass() == null || r.getRetailerPass().trim().isEmpty()) &&
                (r.getRetailerDescription() == null || r.getRetailerDescription().trim().isEmpty())&&
                (r.getIsAvailable() == null || r.getIsAvailable().trim().isEmpty())&&
                (r.getReatilerAddress() == null || r.getReatilerAddress().trim().isEmpty())&&
                (r.getNoOfBarbers() == null || r.getNoOfBarbers().trim().isEmpty())&&
                (r.getTimings() == null || r.getTimings().trim().isEmpty())


        ) {
            throw new RuntimeException("Atleast one value (other than Id or Username) to be provided for update");
        }

        
        Retailer retailer = retailerRepo.save(existingRetailer);
        if (retailer.getRetailerId() != null) {
            return true;
        }
        return false;
    }
    
    public List<Retailer> getRetailersByLocation(String str){
        return retailerRepo.getByRetailerLocationId(str);
    }

    public List<Retailer> getByRetailerName(String name){
        return retailerRepo.getByRetailerName(name);
    }
}
