package prajyot.academiaerp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_payment")

public class Student_payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_payment_id")
    private Long studentPaymentId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "amount" , nullable = false)
    private Long amount;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "payment_date")
    private java.sql.Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "bill_id" , nullable = false)
    private Bills bill;

}