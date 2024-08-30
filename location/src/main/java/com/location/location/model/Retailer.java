package com.location.location.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Retailer {

    private String retailerId;
    private String  retailerName;
    private String  reatilerAddress;
    private String  retailerOwner;
    private String  retailerMobile;
    private String  retailerEmail;
    private String  retailerDescription;
    private String  rating;
    private String  retailerLocationId;
    private String  timings;	
    private String  noOfBarbers;
    private String  isAvailable;
    private String  retailImage;
    private List<Services> serviceList; 

}
