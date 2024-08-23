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

public class CsvUtils {
    public static List<Employee> readCsvFile(InputStream inputStream) throws Exception {
        List<Employee> employees = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        // Skip header row
        reader.readLine();
        
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(","); // Assuming CSV is comma-separated
            int emp_id = Integer.parseInt(values[0]);
            String name = values[1];
            String email = values[2];
            String address = values[3];
            String phone = values[4];
            String department = values[5];
            String designation = values[6];
            boolean isActive = Boolean.parseBoolean(values[7]);
            
            Employee employee = new Employee(emp_id, name, email, address, phone, department, designation, isActive);
            employees.add(employee);
        }
        
        reader.close();
        return employees;
    }
}