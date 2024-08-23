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
    private EmployeeDAO dao;

    public EmployeeService() {
        dao = new EmployeeDAO();
    }

    public void addEmployee(Employee employee) {
        dao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        dao.updateEmployee(employee);
    }

    public void deleteEmployee(int emp_id) {
        dao.deleteEmployee(emp_id);
    }

    public Employee getEmployee(int emp_id) {
        return dao.getEmployee(emp_id);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (PreparedStatement pstmt = dao.getPreparedStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("emp_id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setDepartment(rs.getString("department"));
                employee.setDesignation(rs.getString("designation"));
                employee.setActive(rs.getBoolean("is_active"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void close() {
        dao.close();
    }
}