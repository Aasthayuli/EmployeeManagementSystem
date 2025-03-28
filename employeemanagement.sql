create database employeemanagement;
use employeemanagement;
CREATE TABLE employee (
    name VARCHAR(100),
    father_name VARCHAR(100),
    dob DATE,
    salary DECIMAL(10,2),
    address VARCHAR(255),
    aadhaar VARCHAR(20) UNIQUE,
    phone VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    education VARCHAR(50),
    designation VARCHAR(100),
    empid VARCHAR(20) PRIMARY KEY
);
INSERT INTO employee (name, father_name, dob, salary, address, aadhaar, phone, email, education, designation, empid)  
VALUES ('John Doe', 'Robert Doe', '1990-05-15', 50000.00, '123 Street, City', '123456789012', '9876543210',  
        'johndoe@example.com', 'B.Tech', 'Software Engineer', 'EMP001');
       
