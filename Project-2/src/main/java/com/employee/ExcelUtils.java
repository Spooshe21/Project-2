/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  ExcelUtils.java file
 *   Project:  Employee Management System
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:  	   Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/


package com.employee;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static List<Employee> readExcelFile(InputStream inputStream) throws Exception {
        List<Employee> employees = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Skip header row
            
            int emp_id = 0;
            String name = "";
            String email = "";
            String address = "";
            String phone = "";
            String department = "";
            String designation = "";
            boolean isActive = false;

            // Assuming the columns are in the following order:
            // Emp_id, Name, Email, Address, Phone, Department, Designation, Active

            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                Cell cell = row.getCell(i);
                switch (cell.getCellType()) {
                    case NUMERIC:
                        if (i == 0) { // Emp_id
                            emp_id = (int) cell.getNumericCellValue();
                        } else if (i == 7) { // Active
                            isActive = cell.getBooleanCellValue();
                        } else if (i == 4) { // Phone
                            // Convert numeric phone number to string
                            phone = String.valueOf((long) cell.getNumericCellValue());
                        }
                        break;
                    case STRING:
                        if (i == 1) { // Name
                            name = cell.getStringCellValue();
                        } else if (i == 2) { // Email
                            email = cell.getStringCellValue();
                        } else if (i == 3) { // Address
                            address = cell.getStringCellValue();
                        } else if (i == 4) { // Phone
                            phone = cell.getStringCellValue();
                        } else if (i == 5) { // Department
                            department = cell.getStringCellValue();
                        } else if (i == 6) { // Designation
                            designation = cell.getStringCellValue();
                        }
                        break;
                    default:
                        break; // Handle other cases as needed
                }
            }

            Employee employee = new Employee(emp_id, name, email, address, phone, department, designation, isActive);
            employees.add(employee);
        }
        
        workbook.close();
        return employees;
    }
}