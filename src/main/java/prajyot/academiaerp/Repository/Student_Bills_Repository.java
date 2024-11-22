package prajyot.academiaerp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import prajyot.academiaerp.Entity.Student_bills;

import java.util.List;

public interface Student_Bills_Repository extends JpaRepository<Student_bills, Long> {
    List<Student_bills> findByStudentStudentId(Long studentId);
}