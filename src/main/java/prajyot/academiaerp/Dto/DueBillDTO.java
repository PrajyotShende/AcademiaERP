package prajyot.academiaerp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DueBillDTO {
    private int studentId;
    private Long BillId;
    private String description;
    private double totalFee;
    private double paidAmount;
    private double dueAmount;
}
