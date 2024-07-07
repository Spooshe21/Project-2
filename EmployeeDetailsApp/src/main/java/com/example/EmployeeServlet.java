package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;

	public void init() {
		employeeDAO = new EmployeeDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "list"; // Default action
		}

		try (Connection conn = getConnection()) {
			switch (action) {
			case "edit":
				editEmployee(request, response, conn);
				break;
			case "delete":
				confirmDeleteEmployee(request, response, conn);
				break;
			default:
				listEmployees(request, response, conn);
				break;
			}
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			response.sendRedirect("EmployeeServlet?action=list");
			return;
		}

		try (Connection conn = getConnection()) {
			switch (action) {
			case "insert":
				insertEmployee(request, response, conn);
				break;
			case "update":
				updateEmployee(request, response, conn);
				break;
			default:
				response.sendRedirect("EmployeeServlet?action=list");
				break;
			}
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	private Connection getConnection() throws NamingException, SQLException {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/employee_db");
		return ds.getConnection();
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response, Connection conn) throws ServletException, IOException {
		List<Employee> employees = employeeDAO.getAllEmployees(conn);
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("listEmployee.jsp").forward(request, response);
	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response, Connection conn) throws ServletException, IOException {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String hireDate = request.getParameter("hireDate");
		String jobTitle = request.getParameter("jobTitle");
		String department = request.getParameter("department");
		double salary = Double.parseDouble(request.getParameter("salary"));

		Employee employee = new Employee(emp_id, firstName, lastName, email, phone, hireDate, jobTitle, department, salary);
		employeeDAO.addEmployee(employee, conn);
		response.sendRedirect("EmployeeServlet?action=list");
	}

	private void editEmployee(HttpServletRequest request, HttpServletResponse response, Connection conn) throws ServletException, IOException {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		Employee employee = employeeDAO.getEmployeeById(emp_id, conn);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response, Connection conn) throws ServletException, IOException {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String hireDate = request.getParameter("hireDate");
		String jobTitle = request.getParameter("jobTitle");
		String department = request.getParameter("department");
		double salary = Double.parseDouble(request.getParameter("salary"));

		Employee employee = new Employee(emp_id, firstName, lastName, email, phone, hireDate, jobTitle, department, salary);
		employeeDAO.updateEmployee(employee, conn);
		response.sendRedirect("EmployeeServlet?action=list");
	}

	private void confirmDeleteEmployee(HttpServletRequest request, HttpServletResponse response, Connection conn) throws ServletException, IOException {
		try {
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			Employee employee = employeeDAO.getEmployeeById(emp_id, conn);
			if (employee == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Employee not found");
				return;
			}
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("confirmDeleteEmployee.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Employee ID");
		}
	}
}
