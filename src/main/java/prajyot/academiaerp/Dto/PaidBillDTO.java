//package prajyot.academiaerp.Dto;
//
//import lombok.*;
//import java.util.Date;
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class PaidBillDTO {
//    private Long paymentId;
//    private int studentId;
//    private String description;
//    private double totalFee;
//    private double paidAmount;
//    private double dueAmount;
//    private String status;
//    private Date paymentDate;
////    private List<Double> paidInstallments; // For individual installments
//}


package prajyot.academiaerp.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record PaidBillDTO(
        @JsonProperty("payment_id")
        Long paymentId,

        @JsonProperty("student_id")
        int studentId,

        @JsonProperty("description")
        String description,

        @JsonProperty("total_fee")
        double totalFee,

        @JsonProperty("paid_amount")
        double paidAmount,

        @JsonProperty("due_amount")
        double dueAmount,

        @JsonProperty("status")
        String status,

        @JsonProperty("payment_date")
        Date paymentDate
) {}
