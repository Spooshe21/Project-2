/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  EmployeeDAO.java file
 *   Project:  Employee Management System
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:  	   Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/

package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
	// Database connection instance
	private Connection conn;

	/**
	 * Constructor for EmployeeDAO class. Initializes the database connection using
	 * PostgreSQL JDBC driver.
	 * 
	 * @throws ClassNotFoundException if PostgreSQL Driver class is not found
	 * @throws SQLException           if database access error occurs
	 */
	public EmployeeDAO() {
		try {
			// Load PostgreSQL JDBC driver
			Class.forName("org.postgresql.Driver");
			// Establish a connection to the database
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "Crevavi");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // Log exceptions
		}
	}

	/**
	 * Creates a PreparedStatement object for the provided SQL query.
	 * 
	 * @param query SQL query to be executed
	 * @return PreparedStatement object
	 */
	public PreparedStatement getPreparedStatement(String query) {
		try {
			return conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace(); // Log exceptions
			return null;
		}
	}

	/**
	 * Adds a new employee to the database.
	 * 
	 * @param employee Employee object containing employee details
	 */
	public void addEmployee(Employee employee) {
		// SQL query to insert a new employee record
		String query = "INSERT INTO employees (emp_id, name, email, address, phone, department, designation, is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			// Set parameters for the query
			pstmt.setInt(1, employee.getEmp_id());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getAddress());
			pstmt.setString(5, employee.getPhone());
			pstmt.setString(6, employee.getDepartment());
			pstmt.setString(7, employee.getDesignation());
			pstmt.setBoolean(8, employee.isActive());
			pstmt.executeUpdate(); // Execute the query
		} catch (SQLException e) {
			e.printStackTrace(); // Log exceptions
		}
	}

	/**
	 * Updates an existing employee record in the database.
	 * 
	 * @param employee Employee object containing updated details
	 */
	public void updateEmployee(Employee employee) {
		// SQL query to update an existing employee record
		String query = "UPDATE employees SET name = ?, email = ?, address = ?, phone = ?, department = ?, designation = ?, is_active = ? WHERE emp_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			// Set parameters for the query
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getEmail());
			pstmt.setString(3, employee.getAddress());
			pstmt.setString(4, employee.getPhone());
			pstmt.setString(5, employee.getDepartment());
			pstmt.setString(6, employee.getDesignation());
			pstmt.setBoolean(7, employee.isActive());
			pstmt.setInt(8, employee.getEmp_id());
			pstmt.executeUpdate(); // Execute the query
		} catch (SQLException e) {
			e.printStackTrace(); // Log exceptions
		}
	}

	/**
	 * Deletes an employee record from the database.
	 * 
	 * @param emp_id Unique identifier of the employee to be deleted
	 */
	public void deleteEmployee(int emp_id) {
		// SQL query to delete an employee record
		String query = "DELETE FROM employees WHERE emp_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, emp_id); // Set parameter for the query
			pstmt.executeUpdate(); // Execute the query
		} catch (SQLException e) {
			e.printStackTrace(); // Log exceptions
		}
	}

	/**
	 * Retrieves an employee record from the database based on employee ID.
	 * 
	 * @param emp_id Unique identifier of the employee to be retrieved
	 * @return Employee object with retrieved details
	 */
	public Employee getEmployee(int emp_id) {
		Employee employee = null;
		// SQL query to select an employee record
		String query = "SELECT * FROM employees WHERE emp_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, emp_id); // Set parameter for the query
			ResultSet rs = pstmt.executeQuery(); // Execute the query
			if (rs.next()) {
				employee = new Employee();
				// Populate employee object with result set data
				employee.setId(rs.getInt("emp_id"));
				employee.setName(rs.getString("name"));
				employee.setEmail(rs.getString("email"));
				employee.setAddress(rs.getString("address"));
				employee.setPhone(rs.getString("phone"));
				employee.setDepartment(rs.getString("department"));
				employee.setDesignation(rs.getString("designation"));
				employee.setActive(rs.getBoolean("is_active"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Log exceptions
		}
		return employee;
	}

	/**
	 * Closes the database connection.
	 */
	public void close() {
		try {
			conn.close(); // Close the connection
		} catch (SQLException e) {
			e.printStackTrace(); // Log exceptions
		}
	}
}