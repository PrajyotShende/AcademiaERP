create database if not exists AcademiaERP;

use AcademiaERP;

create table if not exists bills (
    bill_id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    description VARCHAR(255),
    amount BIGINT not null ,
    bill_date DATE ,
    deadline DATE not null
);

create table if not exists student (
    student_id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    first_name VARCHAR(10) not null ,
    last_name VARCHAR(10) ,
    email VARCHAR(255) unique not null ,
    password VARCHAR(255) not null
);

create table if not exists student_bills (
    student_bill_id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    student_id BIGINT ,
    bill_id BIGINT
);

create table if not exists student_payment (
    student_payment_id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    amount BIGINT not null ,
    description VARCHAR(255) ,
    payment_date DATE ,
    total_amt_paid BIGINT DEFAULT 0,
    status ENUM('partial', 'completed', 'due') DEFAULT 'due',
    student_bill_id BIGINT,
    FOREIGN KEY (student_bill_id) REFERENCES student_bills(student_bill_id)
);