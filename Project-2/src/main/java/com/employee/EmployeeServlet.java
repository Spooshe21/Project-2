/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  EmployeeServlet.java file
 *   Project:  Employee Management System
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:  	   Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/


package com.employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;

@MultipartConfig
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService service;

	public EmployeeServlet() {
		service = new EmployeeService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("add".equals(action)) {
			request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
		} else if ("view".equals(action)) {
			List<Employee> employees = service.getAllEmployees();
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("viewEmployees.jsp").forward(request, response);
		} else if ("edit".equals(action)) {
			String emp_idParam = request.getParameter("emp_id");
			if (emp_idParam != null) {
				try {
					int emp_id = Integer.parseInt(request.getParameter("emp_id"));
					Employee employee = service.getEmployee(emp_id);
					request.setAttribute("employee", employee);
					request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
				} catch (NumberFormatException e) {
					// Handle the case when emp_id is not a valid integer
					// You can log the error and redirect to an error page or show a message
					response.sendRedirect("error.jsp?message=Invalid Employee ID");
				}
			} else {
				// Handle the case when emp_id is not present
				response.sendRedirect("error.jsp?message=Employee ID is missing");
			}
		} else if ("delete".equals(action)) {
			String emp_idParam = request.getParameter("emp_id");
	        if (emp_idParam != null) {
	            try {
	            	int emp_id = Integer.parseInt(emp_idParam);
	                // Get employee details for confirmation
	                Employee employee = service.getEmployee(emp_id);
	                if (employee != null) {
	                    request.setAttribute("employee", employee);
	                    request.getRequestDispatcher("deleteEmployee.jsp").forward(request, response);
	                } else {
	                    response.sendRedirect("error.jsp?message=Employee not found");
	                }
	            } catch (NumberFormatException e) {
	                // Handle the case when emp_id is not a valid integer
	                response.sendRedirect("error.jsp?message=Invalid Employee ID");
	            }
	        } else {
	            // Handle the case when emp_id is not present
	            response.sendRedirect("error.jsp?message=Employee ID is missing");
	        }
		} else if ("exportToExcel".equals(action)) {
			List<Employee> employees = service.getAllEmployees();
			exportToExcel(employees, response);
		} else if ("exportToCSV".equals(action)) {
			List<Employee> employees = service.getAllEmployees();
			exportToCSV(employees, response);
		} else if ("importFromExcel".equals(action)) {
			request.getRequestDispatcher("importFromExcel.jsp").forward(request, response);
		} else if ("importFromCSV".equals(action)) {
			request.getRequestDispatcher("importFromCSV.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("add".equals(action)) {
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String department = request.getParameter("department");
			String designation = request.getParameter("designation");
			boolean isActive = request.getParameter("isActive") != null;

			Employee employee = new Employee(emp_id, name, email, address, phone, department, designation, isActive);
			service.addEmployee(employee);
			response.sendRedirect("EmployeeServlet?action=view");
		} else if ("edit".equals(action)) {
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String department = request.getParameter("department");
			String designation = request.getParameter("designation");
			boolean isActive = request.getParameter("isActive") != null;
			Employee employee = new Employee(emp_id, name, email, address, phone, department, designation, isActive);
			service.updateEmployee(employee);
			response.sendRedirect("EmployeeServlet?action=view");
		} else if ("delete".equals(action)) {
			String emp_idParam = request.getParameter("emp_id");
	        if (emp_idParam != null) {
	            try {
	                int emp_id = Integer.parseInt(emp_idParam);
	                service.deleteEmployee(emp_id);
	                request.setAttribute("message", "Employee successfully deleted.");
	                request.getRequestDispatcher("viewEmployees.jsp").forward(request, response);
	            } catch (NumberFormatException e) {
	                response.sendRedirect("error.jsp?message=Invalid Employee ID");
	            }
	        } else {
	            response.sendRedirect("error.jsp?message=Employee ID is missing");
	        }
		}else if ("importFromExcel".equals(action)) {
            Part filePart = request.getPart("excelFile"); // Retrieves <input type="file" name="excelFile">
            if (filePart != null && filePart.getSize() > 0) {
                try (InputStream inputStream = filePart.getInputStream()) {
                    List<Employee> employees = ExcelUtils.readExcelFile(inputStream);
                    for (Employee emp : employees) {
                        service.addEmployee(emp); // Add each employee to the database
                    }
                    request.setAttribute("message", "Employees imported successfully.");
                } catch (Exception e) {
                    request.setAttribute("message", "Error importing employees: " + e.getMessage());
                }
            } else {
                request.setAttribute("message", "No file selected or file is empty.");
            }
            request.getRequestDispatcher("viewEmployees.jsp").forward(request, response);

        } else if ("importFromCSV".equals(action)) {
            Part filePart = request.getPart("csvFile"); // Retrieves <input type="file" name="csvFile">
            if (filePart != null && filePart.getSize() > 0) {
                try (InputStream inputStream = filePart.getInputStream()) {
                    List<Employee> employees = CsvUtils.readCsvFile(inputStream);
                    for (Employee emp : employees) {
                        service.addEmployee(emp); // Add each employee to the database
                    }
                    request.setAttribute("message", "Employees imported successfully.");
                } catch (Exception e) {
                    request.setAttribute("message", "Error importing employees: " + e.getMessage());
                }
            } else {
                request.setAttribute("message", "No file selected or file is empty.");
            }
            request.getRequestDispatcher("viewEmployees.jsp").forward(request, response);
        }
    }

	private void exportToExcel(List<Employee> employees, HttpServletResponse response) throws IOException {
		// Create a new Excel file
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Employees");

		// Set headers
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("Emp_id");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Email");
		row.createCell(3).setCellValue("Address");
		row.createCell(4).setCellValue("Phone");
		row.createCell(5).setCellValue("Department");
		row.createCell(6).setCellValue("Designation");
		row.createCell(7).setCellValue("Active");

		// Add data
		int rowNumber = 1;
		for (Employee employee : employees) {
			row = sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(employee.getEmp_id());
			row.createCell(1).setCellValue(employee.getName());
			row.createCell(2).setCellValue(employee.getEmail());
			row.createCell(3).setCellValue(employee.getAddress());
			row.createCell(4).setCellValue(employee.getPhone());
			row.createCell(5).setCellValue(employee.getDepartment());
			row.createCell(6).setCellValue(employee.getDesignation());
			row.createCell(7).setCellValue(employee.isActive());
		}

		// Write the workbook to the response
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=employees.xlsx");
		workbook.write(response.getOutputStream());
	}

	private void exportToCSV(List<Employee> employees, HttpServletResponse response) throws IOException {
		// Create a CSV file
		String csv = "emp_id,Name,Email,Address,Phone,Department,Designation,Active\n";
		for (Employee employee : employees) {
			csv += employee.getEmp_id() + "," + employee.getName() + "," + employee.getEmail() + ","
					+ employee.getAddress() + "," + employee.getPhone() + "," + employee.getDepartment() + ","
					+ employee.getDesignation() + "," + employee.isActive() + "\n";
		}

		// Write the CSV to the response
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=employees.csv");
		response.getWriter().write(csv);
	}
}