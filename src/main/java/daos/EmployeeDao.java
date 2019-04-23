package daos;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import beans.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();
	List<Employee> getEmployeeById(int id);
	Employee updateEmployee(Employee employee);
	Employee GetEmployeeByLogin(String name, String password, HttpServletResponse response);

}
