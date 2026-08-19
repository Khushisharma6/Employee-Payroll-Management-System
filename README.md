# Employee Payroll Management System

## Project Overview

A Java-based console application for managing employee records and calculating employee payroll.

## Features

* Add Employee
* View All Employees
* Search Employee by ID
* Update Employee
* Delete Employee
* Generate Salary Slip
* Save employee records to CSV
* Load employee records from CSV
* Save salary slips as TXT files
* Input validation
* Duplicate Employee ID prevention
* Negative salary prevention

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList
* File Handling
* CSV
* Exception Handling
* Scanner

## Project Structure

```text
EmployeePayrollManagement/
│
├── src/
│   ├── Main.java
│   ├── Employee.java
│   └── Payroll.java
│
├── data/
│   ├── employees.csv
│   └── salary_slip_ID.txt
│
└── README.md
```

## Payroll Calculation

The application calculates payroll using:

```text
Tax = Basic Salary × 10%

PF = Basic Salary × 12%

Net Salary = Basic Salary - Tax - PF
```

### Example

For a salary of ₹30,000:

```text
Basic Salary = ₹30,000
Tax = ₹3,000
PF = ₹3,600
Net Salary = ₹23,400
```

## How to Run

1. Open the project in VS Code.
2. Make sure Java is installed.
3. Open `Main.java`.
4. Run the program.
5. Select an option from the menu.
6. Employee records will be stored in `data/employees.csv`.
7. Generated salary slips will be stored in the `data` folder.

## Main Menu

```text
======================================
     EMPLOYEE PAYROLL MANAGEMENT
======================================
1. Add Employee
2. View All Employees
3. Generate Salary Slip
4. Search Employee by ID
5. Update Employee
6. Delete Employee
7. Exit
======================================
```

## Concepts Demonstrated

This project demonstrates:

* Classes and Objects
* Encapsulation
* Constructors
* Methods
* ArrayList
* CRUD Operations
* File Reading and Writing
* Exception Handling
* Input Validation
* Basic Payroll Calculations

## Future Enhancements

* MySQL database integration
* Employee login system
* Attendance management
* Leave management
* PDF salary slips
* GUI using Java Swing or JavaFX
* Advanced payroll and tax calculations

## Author

**Khushi Sharma**

Java | SQL | Web Development | Data Analytics
