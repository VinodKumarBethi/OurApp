package com.example.TableService.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TableService.feignClient.FeigncustomerClient;
import com.example.TableService.model.TableRAH;
import com.example.TableService.repo.RAHRepo;

import jakarta.transaction.Transactional;

@Service
public class RAHService implements RAHServiceInterface {

    @Autowired
    FeigncustomerClient feigncustomerClient;

    @Autowired
    private RAHRepo rahRepo;

 

    public List<TableRAH> getRequestByRetIdAndApprovalStatus(String id){

    
        return rahRepo.findByRetIdAndIsAccepted(id, true);

    }
    @Transactional
    public boolean updateOngoingStatus(String requestId,String newStatus){
        int t=rahRepo.updateOngoingStatus(requestId, newStatus);
        if(t>0)
        {
            return true;
        }
        return false;
    }

    @Transactional
    public boolean withdrawalRequest(String requestId){
         int b=rahRepo.deleteByRequestId(requestId);

         if(b>0){
            return true;
         }
        return false;
        
    }
    @Transactional
    public boolean setRetMessage(String requestId,String message){
        TableRAH a=rahRepo.findByRequestId(requestId);

        if(a.getRequestId() !=null){
            a.setRetailerMessage(message);
            return true;
        }
                return false;
    }

    @Override
    public TableRAH getRAHByCustomer(String custId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRAHByCustomer'");
    }
    @Override
    public List<TableRAH> getRAHQueueByRetailer(String retId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRAHQueueByRetailer'");
    }
    @Override
    public TableRAH createRAH(TableRAH rah) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRAH'");
    }
    @Override
    public TableRAH updateApproveOrReject(String requestId, String retId, String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateApproveOrReject'");
    }
    

}
