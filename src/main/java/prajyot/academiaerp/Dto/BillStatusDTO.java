package prajyot.academiaerp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillStatusDTO {
    private Long billId;
    private String description;
    private double totalAmount;
    private double paidAmount;
    private double dueAmount;
    private String status;
}
