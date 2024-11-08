package com.example.TableService.services;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TableService.feignClient.FeigncustomerClient;

import com.example.TableService.model.CustomerServices;
import com.example.TableService.model.ServiceStatus;
import com.example.TableService.model.TableRAH;
import com.example.TableService.repo.CustomerServicesRepo;
import com.example.TableService.repo.RAHRepo;
import com.example.TableService.model.TableRAH;
import com.example.TableService.repo.RAHRepo;

import jakarta.transaction.Transactional;

@Service
public class RAHService implements RAHServiceInterface {
    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // @Autowired
    // private CustomerServices customerSer;

    @Autowired
    FeigncustomerClient feigncustomerClient;

    @Autowired
    private RAHRepo rahRepo;

    @Autowired
    private CustomerServicesRepo cRepo;

    
   

    @Override
    public List<TableRAH> getRAHQueueByRetailer(String retId) {
        List<TableRAH> rahList = rahRepo.findAllByRetIdAndServiceOngoing(retId);
        // returns requests under retaier ID and SrviceOnGoing !=Completed
        return rahList;
    }

    @Override
    public TableRAH createRAH(TableRAH rah) {
        String Id = "REQ_" + UUID.randomUUID().toString();
        String custId = rah.getCustId();
        List<TableRAH> prevRequest = rahRepo.findAllByCustId(custId);

        boolean allCompleted = true;
        for (TableRAH tableRAH : prevRequest) {
            if (!tableRAH.getServiceOngoing().equals(ServiceStatus.COMPLETED)) {
                allCompleted = false;
                break;
            }
        }
        if (prevRequest == null || prevRequest.size() == 0 || allCompleted) {
            rah.setRequestId(Id);
            List<CustomerServices> customerServices=rah.getCustExpectedServices();
            for(int i=0;i<customerServices.size();i++){
                CustomerServices customerSer=new CustomerServices();
                customerSer.setCustomerId(rah.getCustId());
                customerSer.setDuration(customerServices.get(i).getDuration());
                customerSer.setServiceType(customerServices.get(i).getServiceType());
                customerSer.setImages(customerServices.get(i).getImages());
                customerSer.setRetailerId(customerServices.get(i).getRetailerId());
                customerSer.setServiceCost(customerServices.get(i).getServiceCost());
                customerSer.setServiceName(customerServices.get(i).getServiceName());
                customerSer.setServiceId(customerServices.get(i).getServiceId());

                cRepo.save(customerSer);
            }
            return rahRepo.save(rah);
        }

        throw new RuntimeException("Please Withdraw previous request for requesting for new one.");
    }

    @Override
    public TableRAH updateApproveOrReject(String requestId, String retId, boolean isAccepted) {
        TableRAH request = rahRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request does not exist"));
        request.setAccepted(isAccepted);
        request.setServiceOngoing(ServiceStatus.PENDING);

        return rahRepo.save(request);
    }


 

    public List<TableRAH> getRequestByRetIdAndApprovalStatus(String id){

    
        return rahRepo.findByRetIdAndIsAccepted(id, true);

    }
    @Transactional
    public boolean updateOngoingStatus(String requestId,ServiceStatus newStatus){
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
    public List<TableRAH> getRAHByCustomer(String custId) {
         List<TableRAH> rah=rahRepo.findAllByCustId(custId);
        List<CustomerServices> cs=cRepo.getAllCustomerServicesByCustomerId(custId);
        rah.get(0).setCustExpectedServices(cs);

        return rah;

    }

    @Override
    public TableRAH getCurrentRequestByCustomer(String custId) {
        System.out.println("efcsac came here");
        List<TableRAH> prevList = rahRepo.findAllByCustId(custId);
        if (prevList.size() > 0) {
            TableRAH currentRequest = prevList.stream()
                    .filter(tableRAH -> !tableRAH.getServiceOngoing().equals("COMPLETED"))
                    .findFirst()
                    .orElse(null);
            return currentRequest;
        }
        return null;
    }
    

}
