package util;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees(HttpServletRequest request, HttpServletResponse response);
	List<Employee> getEmployeeById(int id);
	List<Employee> updateEmployee(Employee employee);
	Employee createEmployee(HttpServletRequest request, HttpServletResponse response);
	
	
	
}
