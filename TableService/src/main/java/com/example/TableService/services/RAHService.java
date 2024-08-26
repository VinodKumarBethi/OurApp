package com.example.TableService.services;

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
    public Customer getRAHByCustomer(String custToken) {
        Customer  customer = feigncustomerClient.getCustomerById(custToken);

        return customer;
    }

    @Override
    public TableRAH getRAHByRetailer(String retToken) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRAHByRetailer'");
    }


    @Override
    public TableRAH acceptRAHByRetailer(String retToken) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'acceptRAHByRetailer'");
    }

    @Override
    public boolean withDrawRequest(String custToken) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withDrawRequest'");
    }

    @Override
    public boolean makePayment(String custToken) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makePayment'");
    }

    @Override
    public TableRAH createRAH(String CustToken, String retailerUserName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRAH'");
    }

    @Override
    public String sendMsgByRetailer(String retToken, String CustUsername, String msg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendMsgByRetailer'");
    }

    @Override
    public String getMsgByCustomer(String custToken) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMsgByCustomer'");
    }

}
