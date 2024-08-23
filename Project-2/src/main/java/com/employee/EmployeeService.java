/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  EmployeeService.java file
 *   Project:  Employee Management System
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:  	   Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/

package com.employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
// Data Access Object for employee operations
	private EmployeeDAO dao;

	/**
	 * Constructor for EmployeeService class. Initializes the EmployeeDAO instance
	 * for database operations.
	 */
	public EmployeeService() {
		dao = new EmployeeDAO();
	}

	/**
	 * Adds a new employee to the database.
	 * 
	 * @param employee Employee object containing the details to be added
	 */
	public void addEmployee(Employee employee) {
		dao.addEmployee(employee);
	}

	/**
	 * Updates an existing employee record in the database.
	 * 
	 * @param employee Employee object containing the updated details
	 */
	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}

	/**
	 * Deletes an employee record from the database.
	 * 
	 * @param emp_id Unique identifier of the employee to be deleted
	 */
	public void deleteEmployee(int emp_id) {
		dao.deleteEmployee(emp_id);
	}

	/**
	 * Retrieves an employee record from the database based on employee ID.
	 * 
	 * @param emp_id Unique identifier of the employee to be retrieved
	 * @return Employee object with details of the retrieved employee
	 */
	public Employee getEmployee(int emp_id) {
		return dao.getEmployee(emp_id);
	}

	/**
	 * Retrieves all employee records from the database.
	 * 
	 * @return List of Employee objects containing details of all employees
	 */
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String query = "SELECT * FROM employees"; // SQL query to select all employees
		try (PreparedStatement pstmt = dao.getPreparedStatement(query)) {
			ResultSet rs = pstmt.executeQuery(); // Execute the query
			while (rs.next()) {
				Employee employee = new Employee();
				// Populate employee object with result set data
				employee.setId(rs.getInt("emp_id"));
				employee.setName(rs.getString("name"));
				employee.setEmail(rs.getString("email"));
				employee.setAddress(rs.getString("address"));
				employee.setPhone(rs.getString("phone"));
				employee.setDepartment(rs.getString("department"));
				employee.setDesignation(rs.getString("designation"));
				employee.setActive(rs.getBoolean("is_active"));
				employees.add(employee); // Add employee to the list
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Log exceptions
		}
		return employees;
	}

	/**
	 * Closes the data access object and its resources.
	 */
	public void close() {
		dao.close();
	}
}