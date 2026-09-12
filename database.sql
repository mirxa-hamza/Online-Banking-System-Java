-- Online Banking System Database
DROP DATABASE IF EXISTS banksystem;
CREATE DATABASE banksystem;
USE banksystem;

CREATE TABLE signup (
                        form_no VARCHAR(50) PRIMARY KEY,
                        name VARCHAR(100),
                        father_name VARCHAR(100),
                        dob VARCHAR(50),
                        gender VARCHAR(30),
                        email VARCHAR(100),
                        marital_status VARCHAR(50),
                        address VARCHAR(200),
                        city VARCHAR(100),
                        state VARCHAR(100),
                        password VARCHAR(100)
);

CREATE TABLE signup2 (
                         form_no VARCHAR(50) PRIMARY KEY,
                         religion VARCHAR(50),
                         category VARCHAR(50),
                         income VARCHAR(50),
                         education VARCHAR(50),
                         occupation VARCHAR(100),
                         cnic VARCHAR(30),
                         senior_citizen VARCHAR(30),
                         existing_account VARCHAR(30),
                         FOREIGN KEY (form_no) REFERENCES signup(form_no) ON DELETE CASCADE
);

CREATE TABLE signup3 (
                         form_no VARCHAR(50) PRIMARY KEY,
                         account_type VARCHAR(50),
                         account_number VARCHAR(50),
                         pin VARCHAR(30),
                         facility VARCHAR(200),
                         FOREIGN KEY (form_no) REFERENCES signup(form_no) ON DELETE CASCADE
);

CREATE TABLE login (
                       form_no VARCHAR(50) PRIMARY KEY,
                       account_number VARCHAR(50),
                       pin VARCHAR(30) UNIQUE,
                       FOREIGN KEY (form_no) REFERENCES signup(form_no) ON DELETE CASCADE
);

CREATE TABLE bank (
                      pin VARCHAR(30),
                      date VARCHAR(50),
                      type VARCHAR(50),
                      amount VARCHAR(30),
                      INDEX idx_pin (pin)
);

CREATE TABLE admin_login (
                             admin_id INT AUTO_INCREMENT PRIMARY KEY,
                             username VARCHAR(50) NOT NULL UNIQUE,
                             password VARCHAR(100) NOT NULL,
                             email VARCHAR(100)
);

INSERT INTO admin_login (username, password, email) VALUES ('admin', 'admin123', 'admin@banksystem.com');