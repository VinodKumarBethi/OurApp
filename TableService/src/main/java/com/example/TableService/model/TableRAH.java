package com.example.TableService.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


enum ServiceStatus {
    PENDING,
    ONGOING,
    COMPLETED
}

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
    private List<String> custExpectedServices;
    private ServiceStatus serviceOngoing;
    private boolean isPaid;
    private boolean isAccepted;

}

