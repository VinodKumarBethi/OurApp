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

//     public void setServiceOngoing(String string) {
//         switch (string.toUpperCase()) {
//             case "PENDING":
//                 this.serviceOngoing = ServiceStatus.PENDING;
//                 break;
//             case "ONGOING":
//                 this.serviceOngoing = ServiceStatus.ONGOING;
//                 break;
//             case "COMPLETED":
//                 this.serviceOngoing = ServiceStatus.COMPLETED;
//                 break;
//             default:
//                 throw new IllegalArgumentException("Invalid ServiceStatus: " + string);
//         }
//     }
//     public String getServiceOngoing() {
//     switch (this.serviceOngoing) {
//         case PENDING:
//             return "PENDING";
//         case ONGOING:
//             return "ONGOING";
//         case COMPLETED:
//             return "COMPLETED";
//         default:
//             throw new IllegalArgumentException("Invalid ServiceStatus");
//     }
// }

}
