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
    private Connection conn;

    public EmployeeDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "Crevavi");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public PreparedStatement getPreparedStatement(String query) {
        try {
            return conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employees (emp_id,name, email, address, phone, department, designation, is_active) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        	pstmt.setInt(1, employee.getEmp_id());
            pstmt.setString(2, employee.getName());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getAddress());
            pstmt.setString(5, employee.getPhone());
            pstmt.setString(6, employee.getDepartment());
            pstmt.setString(7, employee.getDesignation());
            pstmt.setBoolean(8, employee.isActive());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        String query = "UPDATE employees SET name = ?, email = ?, address = ?, phone = ?, department = ?, designation = ?, is_active = ? WHERE emp_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getAddress());
            pstmt.setString(4, employee.getPhone());
            pstmt.setString(5, employee.getDepartment());
            pstmt.setString(6, employee.getDesignation());
            pstmt.setBoolean(7, employee.isActive());
            pstmt.setInt(8, employee.getEmp_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int emp_id) {
        String query = "DELETE FROM employees WHERE emp_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, emp_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployee(int emp_id) {
        Employee employee = null;
        String query = "SELECT * FROM employees WHERE emp_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, emp_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
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
            e.printStackTrace();
        }
        return employee;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}