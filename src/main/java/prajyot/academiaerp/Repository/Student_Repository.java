package prajyot.academiaerp.Repository;

import prajyot.academiaerp.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Student_Repository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
