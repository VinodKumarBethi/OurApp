package com.location.location.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {

    private String serviceId;	
   private String serviceName;	
   private String serviceCost;
   private String retailerId;
    private String images;
    private String duration;
    private String serviceType;

}
