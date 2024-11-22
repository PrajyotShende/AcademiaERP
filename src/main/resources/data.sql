# INSERT INTO student (first_name, last_name, email, password)
# VALUES
#     ('Prajyot', 'Shende', 'shendeprajyot2@gmail.com', SHA2('Prajyot', 256)),
#     ('John', 'Doe', 'johndoe@example.com', SHA2('password456', 256)),
#     ('Jane', 'Doe', 'janedoe@example.com', SHA2('password789', 256));
#
# -- Inserting data into the bills table
# INSERT INTO bills (description, amount, bill_date, deadline)
# VALUES
#     ('Tuition Fee', 10000, '2024-11-01', '2025-02-01'),
#     ('Library Fee', 2000, '2024-11-01', '2025-02-01'),
#     ('Lab Fee', 3000, '2024-11-01', '2025-03-01');
#
# -- Inserting data into the student_bills table
# INSERT INTO student_bills (student_id, bill_id)
# VALUES
#     (1, 1), -- Prajyot linked to Tuition Fee
#     (1, 2), -- Prajyot linked to Library Fee
#     (2, 2), -- John linked to Library Fee
#     (2, 3), -- John linked to Lab Fee
#     (3, 1); -- Jane linked to Tuition Fee

# INSERT INTO student_payment (amount, description, payment_date, total_amt_paid, status, student_bill_id)
# VALUES
#     (5000, 'First installment of Tuition Fee', '2024-11-23', 5000, 'partial', 1),
#     (2000, 'Full payment of Library Fee', '2024-12-01', 2000, 'completed', 2);
#
# -- Student 2 (John) pays full library fee and part of lab fee
# INSERT INTO student_payment (amount, description, payment_date, total_amt_paid, status, student_bill_id)
# VALUES
#     (2000, 'Full payment of Library Fee', '2024-12-01', 2000, 'completed', 3),
#     (1500, 'Partial payment of Lab Fee', '2024-12-10', 1500, 'partial', 4);
#
# -- Student 3 (Jane) pays full tuition fee
# INSERT INTO student_payment (amount, description, payment_date, total_amt_paid, status, student_bill_id)
# VALUES
#     (10000, 'Full payment of Tuition Fee', '2024-12-01', 10000, 'completed', 5);
# hi