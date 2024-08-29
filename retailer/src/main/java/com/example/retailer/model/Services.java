package com.example.retailer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Services {

   private String serviceId;	
   private String serviceName;	
   private String serviceCost;
   private String retailerId;
    private String images;
    private String duration;
    private String serviceType;

}

