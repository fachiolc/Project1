package connection;

import daos.EmployeeDao;
import daos.EmployeeDaoImpl;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import beans.Employee;
public class ConnectionFactoryTest {
	private EmployeeDao dao = new EmployeeDaoImpl();
	
	@Test
	public void getAllEmployees() {
		System.out.println("get all employees Unit Test");

		List<Employee> employees = dao.getAllEmployees();
		//assertEquals(1, employees.size());
		
		for(Employee employee : employees)
		{
			System.out.println("id:" + employee.getId());
		}
	}
}
