//package prajyot.academiaerp.Dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class DueBillDTO {
//    private int studentId;
//    private Long BillId;
//    private String description;
//    private double totalFee;
//    private double paidAmount;
//    private double dueAmount;
//}
package prajyot.academiaerp.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record DueBillDTO(
        @JsonProperty("student_id")
        int studentId,

        @JsonProperty("bill_id")
        Long billId,

        @JsonProperty("description")
        String description,

        @JsonProperty("total_fee")
        double totalFee,

        @JsonProperty("paid_amount")
        double paidAmount,

        @JsonProperty("due_amount")
        double dueAmount



) {}
