-- Create Tables
CREATE TABLE orgdata (
    id IDENTITY PRIMARY KEY,
    org_name VARCHAR(64) UNIQUE,
    reg_date DATE,
    exp_date DATE,
    enabled BOOL);

CREATE TABLE employeedata (
    id IDENTITY PRIMARY KEY,
    org_id VARCHAR(32),
    first_name VARCHAR(12),
    last_name VARCHAR(12),
    user_name VARCHAR(12),
    password VARCHAR(64),
    email VARCHAR(64),
    tel_no VARCHAR(14),
    FOREIGN KEY (org_id) REFERENCES orgdata(id));

