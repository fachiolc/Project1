package daos;

import java.util.List;

import beans.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee updateEmployee(Employee employee);

}
