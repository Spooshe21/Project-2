package com.example;

public class Employee {
    private int emp_id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String hireDate;
    private String jobTitle;
    private String department;
    private double salary;

    // Constructors
    public Employee(int emp_id, String firstName, String lastName, String email, String phone,
                    String hireDate, String jobTitle, String department, double salary) {
        this.emp_id = emp_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.jobTitle = jobTitle;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getEmp_id() {
        return emp_id;
    }

    public void setId(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method for displaying employee details
    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

}
