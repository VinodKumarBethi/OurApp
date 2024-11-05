package com.example.TableService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
public class CustomerServices {

   @Id
   private String serviceId;	
   private String serviceName;	
   private String serviceCost;
   private String retailerId;
   private String customerId;
    private String images;
    private String duration;
    private String serviceType;

}

