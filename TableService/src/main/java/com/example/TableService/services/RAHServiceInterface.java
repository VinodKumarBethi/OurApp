package com.example.TableService.services;

import java.util.List;

import com.example.TableService.model.TableRAH;

public interface RAHServiceInterface {

    public TableRAH  getRAHByCustomer(String custId);//customer should only able to make one request at a time otherwise need to ask wthdrawl of prev reqwst
    public List<TableRAH>  getRAHQueueByRetailer(String retId);
    public TableRAH createRAH(TableRAH rah);
    public TableRAH updateApproveOrReject(String requestId,String retId,String status);//it updates the  status of the request with approved and serviceOngoing should be updated to pending.
   
    public List<TableRAH> getRequestByRetIdAndApprovalStatus(String Retid);//approved list
    public boolean updateOngoingStatus(String requestId,String newStatus);//it updates the  ongoingstatus of the request with ongoing
    public boolean withdrawalRequest(String requestId);
    public boolean setRetMessage(String requestId,String message);


}
