package prajyot.academiaerp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prajyot.academiaerp.Entity.Student_payment;

import java.util.List;

public interface Student_Payment_Repository extends JpaRepository<Student_payment, Long> {

}