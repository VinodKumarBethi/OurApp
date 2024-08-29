package com.example.retailer.dto;



import com.example.retailer.model.Services;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetailerDto {
    
    private String retailerId;
    private String  retailerName;//
    private String  reatilerAddress;//
    private String  retailerOwner;//
    private String  retailerMobile;	//
    private String  retailerEmail;//
    private String  retailerDescription;//
    private String  rating;
    private String  retailerLocationId;
    private String  timings;	//
    private String  noOfBarbers;//
    private String  isAvailable;//
    private String  retailImage;//
    private List<Services> serviceList; 


}
