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
	// Unique identifier for the employee
	private int emp_id;
	//Name of the employee
	private String name;

	//Email address of the employee
	private String email;

	//Residential address of the employee
	private String address;

	//Phone number of the employee
	private String phone;

	//Department where the employee works
	private String department;

	//Designation or job title of the employee
	private String designation;

	//Status indicating whether the employee is active or not
	private boolean isActive;

	/**
	 * Default constructor for Employee class. Initializes an employee object with
	 * default values.
	 */
	public Employee() {
	}

	/**
	 * Parameterized constructor for Employee class. Initializes an employee object
	 * with specified values.
	 * 
	 * @param emp_id      unique identifier for the employee
	 * @param name        name of the employee
	 * @param email       email address of the employee
	 * @param address     residential address of the employee
	 * @param phone       phone number of the employee
	 * @param department  department where the employee works
	 * @param designation job title of the employee
	 * @param isActive    status of the employee
	 */
	public Employee(int emp_id, String name, String email, String address, String phone, String department,
			String designation, boolean isActive) {
		this.emp_id = emp_id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.department = department;
		this.designation = designation;
		this.isActive = isActive;
	}

	/**
	 * Overloaded constructor for Employee class without employee ID. Used for
	 * creating new employee records where ID is not yet assigned.
	 * 
	 * @param name        name of the employee
	 * @param email       email address of the employee
	 * @param address     residential address of the employee
	 * @param phone       phone number of the employee
	 * @param department  department where the employee works
	 * @param designation job title of the employee
	 * @param isActive    status of the employee
	 */
	public Employee(String name, String email, String address, String phone, String department, String designation,
			boolean isActive) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.department = department;
		this.designation = designation;
		this.isActive = isActive;
	}

	//Getter and Setter methods

	/**
	 * Gets the employee ID.
	 * 
	 * @return the employee ID
	 */
	public int getEmp_id() {
		return emp_id;
	}

	/**
	 * Sets the employee ID.
	 * 
	 * @param emp_id the employee ID to set
	 */
	public void setId(int emp_id) {
		this.emp_id = emp_id;
	}

	/**
	 * Gets the name of the employee.
	 * 
	 * @return the name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the employee.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email address of the employee.
	 * 
	 * @return the email address of the employee
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the employee.
	 * 
	 * @param email the email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the residential address of the employee.
	 * 
	 * @return the address of the employee
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the residential address of the employee.
	 * 
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the phone number of the employee.
	 * 
	 * @return the phone number of the employee
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone number of the employee.
	 * 
	 * @param phone the phone number to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the department where the employee works.
	 * 
	 * @return the department of the employee
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the department where the employee works.
	 * 
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Gets the designation or job title of the employee.
	 * 
	 * @return the designation of the employee
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation or job title of the employee.
	 * 
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Checks if the employee is active.
	 * 
	 * @return true if the employee is active, otherwise false
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Sets the active status of the employee.
	 * 
	 * @param isActive the status to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}