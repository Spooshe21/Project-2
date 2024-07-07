package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for managing Employee data.
 */
public class EmployeeDAO {

    /**
     * Retrieves all employees from the database.
     *
     * @param conn the database connection
     * @return a list of employees
     */
    public List<Employee> getAllEmployees(Connection conn) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int emp_id = rs.getInt("emp_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String hireDate = rs.getString("hire_date");
                String jobTitle = rs.getString("job_title");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                Employee employee = new Employee(emp_id, firstName, lastName, email, phone, hireDate, jobTitle, department, salary);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id   the employee ID
     * @param conn the database connection
     * @return the employee, or null if not found
     */
    public Employee getEmployeeById(int emp_id, Connection conn) {
        Employee employee = null;
        String sql = "SELECT * FROM employees WHERE emp_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emp_id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String hireDate = rs.getString("hire_date");
                    String jobTitle = rs.getString("job_title");
                    String department = rs.getString("department");
                    double salary = rs.getDouble("salary");

                    employee = new Employee(emp_id, firstName, lastName, email, phone, hireDate, jobTitle, department, salary);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    /**
     * Adds a new employee to the database.
     *
     * @param employee the employee to add
     * @param conn     the database connection
     */
    public void addEmployee(Employee employee, Connection conn) {
        String sql = "INSERT INTO employees (emp_id,first_name, last_name, email, phone, hire_date, job_title, department, salary) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, employee.getEmp_id());
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhone());
            stmt.setString(5, employee.getHireDate());
            stmt.setString(6, employee.getJobTitle());
            stmt.setString(7, employee.getDepartment());
            stmt.setDouble(8, employee.getSalary());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing employee in the database.
     *
     * @param employee the employee to update
     * @param conn     the database connection
     */
    public void updateEmployee(Employee employee, Connection conn) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone = ?, " +
                     "hire_date = ?, job_title = ?, department = ?, salary = ? WHERE emp_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhone());
            stmt.setString(5, employee.getHireDate());
            stmt.setString(6, employee.getJobTitle());
            stmt.setString(7, employee.getDepartment());
            stmt.setDouble(8, employee.getSalary());
            stmt.setInt(9, employee.getEmp_id());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an employee from the database.
     *
     * @param id   the employee ID
     * @param conn the database connection
     */
    public void deleteEmployee(int emp_id, Connection conn) {
        String sql = "DELETE FROM employees WHERE emp_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emp_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other methods for exporting and importing employees can be added here
}
