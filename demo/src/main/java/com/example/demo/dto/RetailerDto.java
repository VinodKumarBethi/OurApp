package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
