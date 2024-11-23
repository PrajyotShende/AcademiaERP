package prajyot.academiaerp.Service;

import prajyot.academiaerp.Repository.Bills_Repository;
import prajyot.academiaerp.Repository.Student_Bills_Repository;
import prajyot.academiaerp.Repository.Student_Payment_Repository;
import prajyot.academiaerp.Dto.BillStatusDTO;
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

    public List<BillStatusDTO> getBillsForStudent(int studentId) {
        List<BillStatusDTO> billStatusList = new ArrayList<>();

        // Step 1: Retrieve all bills for the student
        List<Object[]> studentBills = studentBillsRepository.findBillsByStudentId(studentId);

        for (Object[] billData : studentBills) {
            Long studentBillId = (Long) billData[0];  // studentBillId is Long
            Long billId = (Long) billData[1];          // billId is Long
            String description = (String) billData[2];
            Long totalAmountLong = (Long) billData[3]; // Assuming totalAmount is returned as Long

            // Convert totalAmount from Long to double
            double totalAmount = totalAmountLong != null ? totalAmountLong.doubleValue() : 0.0;

            // Step 2: Calculate paid amount
            Double paidAmount = studentPaymentRepository.getTotalPaidAmountForStudentBill(studentBillId);
            if (paidAmount == null) {
                paidAmount = 0.0;
            }

            // Step 3: Determine due amount and status
            double dueAmount = totalAmount - paidAmount;
            String status = (dueAmount > 0) ? "partial" : "completed";

            // Add to result list
            billStatusList.add(new BillStatusDTO(billId, description, totalAmount, paidAmount, dueAmount, status));
        }

        return billStatusList;
    }
}
