package prajyot.academiaerp.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
