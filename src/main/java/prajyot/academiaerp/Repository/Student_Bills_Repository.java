package prajyot.academiaerp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import prajyot.academiaerp.Entity.Student_bills;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface Student_Bills_Repository extends JpaRepository<Student_bills, Long> {
    List<Student_bills> findByStudentStudentId(int student_id);
    @Query("SELECT sb.studentBillId, sb.bill.billId, sb.bill.description, sb.bill.amount FROM Student_bills sb WHERE sb.student.studentId = :studentId")
    List<Object[]> findBillsByStudentId(int studentId);
}