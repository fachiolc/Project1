package util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Employee;
import daos.EmployeeDao;
import daos.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDao dao = new EmployeeDaoImpl();
	// Object mapper to turn Employee object into JSON
	
	@Override
	public List<Employee> getAllEmployees(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("EmployeeServiceImpl - getAllEmployees");
		return dao.getAllEmployees();
	}

	@Override
	public List<Employee> getEmployeeById(int id) {
		System.out.println("EmployeeServiceImpl - getEmployeeById");
		return dao.getEmployeeById(id);
	}

	@Override
	public List<Employee> updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee createEmployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
