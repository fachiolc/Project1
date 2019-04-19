package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import beans.Employee;
import util.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			// Get connection 
			Statement stmt = conn.createStatement();
			// Execute statement
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
			// Populate list from ResultSet
			while (rs.next()) {
				employees.add(new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("EMPLOYEE_NAME"), rs.getString("EMPLOYEE_PASSWORD"), rs.getString("EMPLOYEE_EMAIL"), rs.getString("EMPLOYEE_PASSWORD")));
			}
			System.out.println("Connected");
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			// Get connection
			Statement stmt = conn.createStatement();
			// Execute statement
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = " + id ) ;
			// Populate list from ResultSet
			if (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("EMLOYEE_ID"));
				e.setName(rs.getString("EMPLOYEE_NAME"));
				e.setPosition(rs.getString("EMPLOYEE_POSITION"));
				e.setEmail(rs.getString("EMPLOYEE_PASSWORD"));
				return e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	
	@Override
	public Employee GetEmployeeByLogin(String name, String password, HttpServletResponse response) {
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			// Get connection
			Statement stmt = conn.createStatement();
			// Execute
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_NAME='" + name + "' AND EMPLOYEE_PASSWORD='" + password + "'");
			rs.next();
			if (rs != null) {
				Employee employee = new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("EMPLOYEE_NAME"), rs.getString("EMPLOYEE_POSITION"), rs.getString("EMPLOYEE_EMAIL"), rs.getString("EMPLOYEE_PASSWORD"));
				return employee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee updateEmployee(String employee_name, String newPassword) {
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			// Get connection
			Statement stmt = conn.createStatement();
			// Execute
			ResultSet rs = stmt.executeQuery("UPDATE EMPLOYEES SET EMPLOYEE_PASSWORD WHERE " + Employee.getId());
			// Populate
			if (rs.next()) {
				Employee e = new Employee();
				// TODO; fix this password
				e.setPassword("");
				return e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
