package com.example.TableService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TableService.feignClient.FeigncustomerClient;
import com.example.TableService.model.Customer;
import com.example.TableService.model.ServiceStatus;
import com.example.TableService.model.TableRAH;
import com.example.TableService.repo.RAHRepo;

@Service
public class RAHService implements RAHServiceInterface {
    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    @Autowired
    FeigncustomerClient feigncustomerClient;

    @Autowired
    RAHRepo rahRepo;

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
    public List<TableRAH> getRAHByCustomer(String custId) {
        return rahRepo.findAllByCustId(custId);

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
