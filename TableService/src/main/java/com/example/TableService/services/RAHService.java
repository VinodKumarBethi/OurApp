package com.example.TableService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TableService.feignClient.FeigncustomerClient;
import com.example.TableService.model.Customer;
import com.example.TableService.model.TableRAH;

@Service
public class RAHService implements RAHServiceInterface {

    @Autowired
    FeigncustomerClient feigncustomerClient;

 

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

    @Override
    public List<TableRAH> getRequestByRetIdAndApprovalStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRequestByRetIdAndApprovalStatus'");
    }

    @Override
    public TableRAH updateOngoingStatus(String requestId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOngoingStatus'");
    }

    @Override
    public String withdrawalRequest(String requestId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdrawalRequest'");
    }

    @Override
    public String setMessage(String requestId, String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMessage'");
    }

    @Override
    public TableRAH getRAHByCustomer(String custId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRAHByCustomer'");
    }

}
