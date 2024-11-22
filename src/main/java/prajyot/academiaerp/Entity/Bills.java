package prajyot.academiaerp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bills")

public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "bill_date")
    private java.sql.Date billDate;

    @Column(name = "deadline", nullable = false)
    private java.sql.Date deadline;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Student_bills> studentBills;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Student_payment> studentPayments;


}
