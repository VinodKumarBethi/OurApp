package com.example.TableService.services;

import com.example.TableService.model.Customer;
import com.example.TableService.model.TableRAH;

public interface RAHServiceInterface {

    public Customer  getRAHByCustomer(String custToken);
    public TableRAH  getRAHByRetailer(String retToken);
    public TableRAH createRAH(String CustToken,String retailerUserName);
    public TableRAH acceptRAHByRetailer(String retToken);
    public boolean withDrawRequest(String custToken);
    public boolean makePayment(String custToken);
    public String sendMsgByRetailer(String retToken,String CustUsername,String msg);
    public String getMsgByCustomer(String custToken);
    

}
