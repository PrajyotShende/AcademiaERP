USE AcademiaERP;

ALTER TABLE student_bills
    ADD CONSTRAINT fk_student_bills_student_id
        FOREIGN KEY (student_id)
            REFERENCES student(student_id)
            ON DELETE CASCADE;

ALTER TABLE student_bills
    ADD CONSTRAINT fk_student_bills_bill_id
        FOREIGN KEY (bill_id)
            REFERENCES bills(bill_id)
            ON DELETE CASCADE;

# ALTER TABLE student_payment
#     ADD CONSTRAINT fk_student_payment_student_id
#         FOREIGN KEY (student_id)
#             REFERENCES student(student_id)
#             ON DELETE CASCADE;
#
# ALTER TABLE student_payment
#     ADD CONSTRAINT fk_student_payment_bill_id
#         FOREIGN KEY (bill_id)
#             REFERENCES bills(bill_id)
#             ON DELETE CASCADE;
