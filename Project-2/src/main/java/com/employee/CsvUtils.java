/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  CsvUtils.java file
 *   Project:  Employee Management System
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:  	   Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/


package com.employee;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for handling CSV file operations related to employee data.
 */
public class CsvUtils {

    /**
     * Reads a CSV file from the provided InputStream and converts each row into an Employee object.
     * 
     * @param inputStream the InputStream of the CSV file to be read
     * @return a List of Employee objects parsed from the CSV file
     * @throws Exception if an error occurs while reading the file or parsing data
     */
    public static List<Employee> readCsvFile(InputStream inputStream) throws Exception {
        // List to store employee objects parsed from the CSV file
        List<Employee> employees = new ArrayList<>();
        
        // Create a BufferedReader to read the CSV file from the InputStream
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        // Skip the header row of the CSV file
        reader.readLine();
        
        // Read each line of the CSV file
        while ((line = reader.readLine()) != null) {
            // Split the line by comma to extract values
            String[] values = line.split(","); // Assuming CSV is comma-separated
            
            // Parse and assign each value to corresponding fields of Employee
            int emp_id = Integer.parseInt(values[0]); // Employee ID
            String name = values[1]; // Employee name
            String email = values[2]; // Employee email
            String address = values[3]; // Employee address
            String phone = values[4]; // Employee phone number
            String department = values[5]; // Employee department
            String designation = values[6]; // Employee designation
            boolean isActive = Boolean.parseBoolean(values[7]); // Employee status
            
            // Create an Employee object with the parsed values
            Employee employee = new Employee(emp_id, name, email, address, phone, department, designation, isActive);
            
            // Add the Employee object to the list
            employees.add(employee);
        }
        
        // Close the BufferedReader
        reader.close();
        
        // Return the list of Employee objects
        return employees;
    }
}
