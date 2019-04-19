package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {
	
	public ConnectionFactory() {
	}
	public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CFachiol","313vatorS!");
        } catch (SQLException e) {
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            throw new RuntimeException("Cannot connect");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot locate driver");
        }		
	}
}
