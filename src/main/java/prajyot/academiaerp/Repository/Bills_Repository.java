package prajyot.academiaerp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prajyot.academiaerp.Entity.Bills;

@Repository
public interface Bills_Repository extends JpaRepository<Bills, Long> {
}
