package prajyot.academiaerp.Mapper;

import prajyot.academiaerp.Dto.DueBillDTO;
import prajyot.academiaerp.Dto.PaidBillDTO;
import prajyot.academiaerp.Entity.Student_payment;
import prajyot.academiaerp.Entity.Bills;
import java.util.Date;

public class BillingMapper {

    public static PaidBillDTO toPaidBillDTO(Student_payment payment, int studentId, String description, double totalFee, double totalPaidAmount, double dueAmount, String status) {
        return new PaidBillDTO(
                payment.getStudentPaymentId(),
                studentId,
                description,
                totalFee,
                totalPaidAmount,
                dueAmount,
                status,
                payment.getPaymentDate()
        );
    }

    public static DueBillDTO toDueBillDTO(int studentId, Long billId, String description, double totalFee, double paidAmount, double dueAmount) {
        return new DueBillDTO(
                studentId,
                billId,
                description,
                totalFee,
                paidAmount,
                dueAmount
        );
    }
}
