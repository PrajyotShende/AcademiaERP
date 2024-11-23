package prajyot.academiaerp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prajyot.academiaerp.Entity.Student_payment;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
@Repository
public interface Student_Payment_Repository extends JpaRepository<Student_payment, Long> {
    @Query("SELECT SUM(sp.amount) FROM Student_payment sp WHERE sp.studentBill.studentBillId = :studentBillId")
    Double getTotalPaidAmountForStudentBill(long studentBillId);
}