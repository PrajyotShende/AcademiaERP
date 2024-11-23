package prajyot.academiaerp.Service;

import prajyot.academiaerp.Repository.Bills_Repository;
import prajyot.academiaerp.Repository.Student_Bills_Repository;
import prajyot.academiaerp.Repository.Student_Payment_Repository;
import prajyot.academiaerp.Dto.PaidBillDTO;
import prajyot.academiaerp.Dto.DueBillDTO;
import prajyot.academiaerp.Entity.Student_payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Service
public class BillingService {

    @Autowired
    private Student_Bills_Repository studentBillsRepository;

    @Autowired
    private Bills_Repository billRepository;

    @Autowired
    private Student_Payment_Repository studentPaymentRepository;

    // Fetch Paid Bills for a Student
    public List<PaidBillDTO> getPaidBillsForStudent(int studentId) {
        List<PaidBillDTO> paidBillsList = new ArrayList<>();

        List<Object[]> studentBills = studentBillsRepository.findBillsByStudentId(studentId);

        for (Object[] billData : studentBills) {
            Long studentBillId = (Long) billData[0];
            Long billId = (Long) billData[1];
            String description = (String) billData[2];
            Long totalAmountLong = (Long) billData[3];
            double totalAmount = totalAmountLong != null ? totalAmountLong.doubleValue() : 0.0;

            // Fetch all paid installments for this bill
            List<Student_payment> paidInstallments = studentPaymentRepository.findByStudentBillId(studentBillId);
            double totalPaidAmount = 0.0;

            // Loop over each payment installment and create a separate entry for each installment
            for (Student_payment payment : paidInstallments) {
                double paidAmount = payment.getAmount();
                totalPaidAmount += paidAmount;

                double dueAmount = totalAmount - totalPaidAmount;
                String status = (dueAmount > 0) ? "partial" : "complete";

                // Add the installment entry
                paidBillsList.add(new PaidBillDTO(
                        payment.getStudentPaymentId(), // paymentId
                        studentId,
                        description,
                        totalAmount,
                        paidAmount,
                        dueAmount,
                        status,
                        payment.getPaymentDate()
                ));
            }
        }

        return paidBillsList;
    }

    // Fetch Due Bills for a Student
    public List<DueBillDTO> getDueBillsForStudent(int studentId) {
        List<DueBillDTO> dueBillsList = new ArrayList<>();

        List<Object[]> studentBills = studentBillsRepository.findBillsByStudentId(studentId);

        for (Object[] billData : studentBills) {
            Long studentBillId = (Long) billData[0];
            Long billId = (Long) billData[1];  // This fetches the actual bill_id from the bills table
            String description = (String) billData[2];
            Long totalAmountLong = (Long) billData[3];
            double totalAmount = totalAmountLong != null ? totalAmountLong.doubleValue() : 0.0;

            // Get the total paid amount for this student bill
            Double paidAmount = studentPaymentRepository.getTotalPaidAmountForStudentBill(studentBillId);
            if (paidAmount == null) {
                paidAmount = 0.0;
            }

            double dueAmount = totalAmount - paidAmount;

            // Only include bills where there is an outstanding due amount
            if (dueAmount > 0) {
                dueBillsList.add(new DueBillDTO(studentId, billId, description, totalAmount, paidAmount, dueAmount));
            }
        }

        return dueBillsList;
    }

}
