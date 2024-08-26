package com.example.TableService.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String rahId;
    private String custId;
    private String retId;
    private String requestId;
    private String requestTimeStamp;
    private String retailerMessage;
    private String timeForCustArrival;
    private List<String> custExpectedServices;
    private boolean serviceOngoing;
    private boolean isPaid;
    private boolean isAccepted;

}
