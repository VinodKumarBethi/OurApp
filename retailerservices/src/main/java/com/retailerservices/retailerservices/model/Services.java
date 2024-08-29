package com.retailerservices.retailerservices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Services {

   @Id
   private String serviceId;	
   private String serviceName;	
   private String serviceCost;
   private String retailerId;
    private String images;
    private String duration;
    private String serviceType;

}
