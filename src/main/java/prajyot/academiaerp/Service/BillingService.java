package prajyot.academiaerp.Service;

import prajyot.academiaerp.Repository.Bills_Repository;
import prajyot.academiaerp.Repository.Student_Bills_Repository;
import prajyot.academiaerp.Repository.Student_Payment_Repository;
import prajyot.academiaerp.Dto.PaidBillDTO;
import prajyot.academiaerp.Dto.DueBillDTO;
import prajyot.academiaerp.Entity.Student_payment;
import prajyot.academiaerp.Mapper.BillingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BillingService {

    @Autowired
    private Student_Bills_Repository studentBillsRepository;

    @Autowired
    private Bills_Repository billRepository;

    @Autowired
    private Student_Payment_Repository studentPaymentRepository;

    public List<PaidBillDTO> getPaidBillsForStudent(int studentId) {
        List<PaidBillDTO> paidBillsList = new ArrayList<>();
        List<Object[]> studentBills = studentBillsRepository.findBillsByStudentId(studentId);

        for (Object[] billData : studentBills) {
            Long studentBillId = (Long) billData[0];
            Long billId = (Long) billData[1];
            String description = (String) billData[2];
            Long totalAmountLong = (Long) billData[3];
            double totalAmount = totalAmountLong != null ? totalAmountLong.doubleValue() : 0.0;

            List<Student_payment> paidInstallments = studentPaymentRepository.findByStudentBillId(studentBillId);
            double totalPaidAmount = 0.0;

            for (Student_payment payment : paidInstallments) {
                double paidAmount = payment.getAmount();
                totalPaidAmount += paidAmount;
                double dueAmount = totalAmount - totalPaidAmount;
                String status = (dueAmount > 0) ? "partial" : "complete";

                paidBillsList.add(BillingMapper.toPaidBillDTO(
                        payment,
                        studentId,
                        description,
                        totalAmount,
                        paidAmount,
                        dueAmount,
                        status
                ));
            }
        }

        return paidBillsList;
    }

    public List<DueBillDTO> getDueBillsForStudent(int studentId) {
        List<DueBillDTO> dueBillsList = new ArrayList<>();
        List<Object[]> studentBills = studentBillsRepository.findBillsByStudentId(studentId);

        for (Object[] billData : studentBills) {
            Long studentBillId = (Long) billData[0];
            Long billId = (Long) billData[1];
            String description = (String) billData[2];
            Long totalAmountLong = (Long) billData[3];
            double totalAmount = totalAmountLong != null ? totalAmountLong.doubleValue() : 0.0;

            Double paidAmount = studentPaymentRepository.getTotalPaidAmountForStudentBill(studentBillId);
            if (paidAmount == null) {
                paidAmount = 0.0;
            }

            double dueAmount = totalAmount - paidAmount;

            if (dueAmount > 0) {
                dueBillsList.add(BillingMapper.toDueBillDTO(
                        studentId,
                        billId,
                        description,
                        totalAmount,
                        paidAmount,
                        dueAmount
                ));
            }
        }

        return dueBillsList;
    }
}
