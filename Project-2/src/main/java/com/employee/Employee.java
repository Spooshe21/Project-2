/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  Employee.java file
 *   Project:  Employee Management System
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:  	   Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/


package com.employee;

public class Employee {
    private int emp_id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String department;
    private String designation;
    private boolean isActive;

    // Default constructor
    public Employee() {
    }

    // Constructor with parameters
    public Employee(int emp_id, String name, String email, String address, String phone, String department, String designation, boolean isActive) {
        this.emp_id = emp_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.department = department;
        this.designation = designation;
        this.isActive = isActive;
    }

    // Overloaded constructor for adding new employees (without id)
    public Employee(String name, String email, String address, String phone, String department, String designation, boolean isActive) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.department = department;
        this.designation = designation;
        this.isActive = isActive;
    }

    // Getters and Setters
    public int getEmp_id() {
        return emp_id;
    }

    public void setId(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}