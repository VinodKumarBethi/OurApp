package com.example.TableService.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class TableRAH {

    @Id
    private String requestId;
    private String custId;
    private String retId;
    private String requestTimeStamp;
    private String retailerMessage;
    private String timeForCustArrival;
  
    @Transient
    private List<CustomerServices> custExpectedServices;
    
    private ServiceStatus serviceOngoing;
    private boolean isPaid;
    private boolean isAccepted;

   

}
