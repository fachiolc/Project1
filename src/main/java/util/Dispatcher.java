package util;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher {
	// Creating the DAO
	private static final EmployeeService employeeService = new EmployeeServiceImpl();
	// Restrict Instantiation - Turning into Singleton
	private Dispatcher() {}
	// Process Redirect
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		final String uri = request.getRequestURI().replace("/Project1_1/api", "");
		System.out.println("Inside Dispatcher: " + request.getMethod() + " request going to " + uri);
		switch(uri) {
		case "/employee":
			int id = (int) request.getAttribute("employee");
			return employeeService.getEmployeeById(id);
		case "/employees":
			return employeeService.getAllEmployees(request, response);
		default:
			return Collections.singletonMap("message", response);
		}
	}
	// ProcessPost
	public static Object processPost(HttpServletRequest request, HttpServletResponse response) {
		final String uri = request. getRequestURI().replace("/Project1_1/api","");
		System.out.println("Inside Dispatcher: " + request.getMethod() + " request going to " + uri);
		switch(uri) {
		case "/employees":
			return employeeService.createEmployee(request, response);
		default:
			return Collections.singletonMap("message", "processPost not implemented");
		}
	}
}
