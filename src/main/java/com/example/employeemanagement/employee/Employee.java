package com.example.employeemanagement.employee;

public class Employee {

    private String employeeCode;
    private String fullName;
    private String email;

    public Employee() {
    }

    public Employee(String employeeCode, String fullName, String email) {
        this.employeeCode = employeeCode;
        this.fullName = fullName;
        this.email = email;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
