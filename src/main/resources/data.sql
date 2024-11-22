# INSERT INTO student (first_name, last_name, email, password)
# VALUES
#     ('Prajyot', 'Shende', 'shendeprajyot2@gmail.com', SHA2('Prajyot', 256)),
#     ('John', 'Doe', 'johndoe@example.com', SHA2('password456', 256)),
#     ('Jane', 'Doe', 'janedoe@example.com', SHA2('password789', 256));
#
# INSERT INTO bills (description, amount, bill_date, deadline)
# VALUES
#     ('Tuition Fee', 10000, '2024-11-01', '2025-02-01'),
#     ('Library Fee', 2000, '2024-11-01', '2025-02-01'),
#     ('Lab Fee', 3000, '2024-11-01', '2025-03-01');


#
# INSERT INTO student_bills (student_id, bill_id)
# VALUES
#     (1, 1), -- Prajyot linked to Tuition Fee
#     (1, 2), -- Prajyot linked to Library Fee
#     (2, 2), -- John linked to Library Fee
#     (2, 3), -- John linked to Lab Fee
#     (3, 1); -- Jane linked to Tuition Fee

-- Student 1 (Prajyot) pays part of the tuition fee and full library fee
# INSERT INTO student_payment (student_id, amount, description, payment_date, bill_id, status, total_amt_paid, student_bill_id)
# VALUES
#     (1, 5000, 'First installment of Tuition Fee', '2024-11-23', 1, 'partial', 5000, 1),
#     (1, 2000, 'Full payment of Library Fee', '2024-12-01', 2, 'completed', 2000, 2);
#
# -- Student 2 (John) pays full library fee and part of lab fee
# INSERT INTO student_payment (student_id, amount, description, payment_date, bill_id, status, total_amt_paid, student_bill_id)
# VALUES
#     (2, 2000, 'Full payment of Library Fee', '2024-12-01', 2, 'completed', 2000, 3),
#     (2, 1500, 'Partial payment of Lab Fee', '2024-12-10', 3, 'partial', 1500, 4);
#
# -- Student 3 (Jane) pays full tuition fee
# INSERT INTO student_payment (student_id, amount, description, payment_date, bill_id, status, total_amt_paid, student_bill_id)
# VALUES
#     (3, 10000, 'Full payment of Tuition Fee', '2024-12-01', 1, 'completed', 10000, 5);
#
