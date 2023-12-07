
CREATE DATABASE IF NOT EXISTS thi;

USE thi;


CREATE TABLE Student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name TEXT,
    dob DATE,
    department TEXT,
    selected INT
);


INSERT INTO Student (name, dob, department, selected)
VALUES
    ('John Doe', '1995-05-15', 'Computer Science', 1),
    ('Jane Smith', '1998-08-25', 'Mathematics', 0),
    ('Bob Johnson', '1997-03-10', 'Physics', 1);
