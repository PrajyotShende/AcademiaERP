package prajyot.academiaerp.Dto;

import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaidBillDTO {
    private Long paymentId;
    private int studentId;
    private String description;
    private double totalFee;
    private double paidAmount;
    private double dueAmount;
    private String status;
    private Date paymentDate;
//    private List<Double> paidInstallments; // For individual installments
}
