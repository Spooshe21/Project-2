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

/**
 * Utility class for handling Excel file operations related to Employee data.
 * This class provides methods to read employee information from an Excel file and
 * convert it into a list of Employee objects.
 */
public class ExcelUtils {

    /**
     * Reads employee data from an Excel file and converts it into a list of Employee objects.
     * Assumes that the Excel file follows a specific format with columns for employee details.
     * 
     * @param inputStream The input stream of the Excel file to be read.
     * @return A list of Employee objects populated with data from the Excel file.
     * @throws Exception If an error occurs while reading the Excel file.
     */
    public static List<Employee> readExcelFile(InputStream inputStream) throws Exception {
        List<Employee> employees = new ArrayList<>();
        
        // Create a workbook instance from the input stream
        Workbook workbook = new XSSFWorkbook(inputStream);
        
        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);
        
        // Iterate through all rows in the sheet
        for (Row row : sheet) {
            // Skip the header row
            if (row.getRowNum() == 0) continue;
            
            int emp_id = 0;
            String name = "";
            String email = "";
            String address = "";
            String phone = "";
            String department = "";
            String designation = "";
            boolean isActive = false;

            // Process each cell in the row based on its type and column index
            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                Cell cell = row.getCell(i);
                
                // Determine the type of cell and extract the appropriate value
                switch (cell.getCellType()) {
                    case NUMERIC:
                        // Handle numeric cell types
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
                        // Handle string cell types
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
                        break; // Handle other cell types if necessary
                }
            }

            // Create an Employee object with the extracted data and add it to the list
            Employee employee = new Employee(emp_id, name, email, address, phone, department, designation, isActive);
            employees.add(employee);
        }
        
        // Close the workbook to free up resources
        workbook.close();
        
        return employees;
    }
}
