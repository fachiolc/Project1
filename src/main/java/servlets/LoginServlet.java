package servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionFactory;

//Servlet implementation class LoginServlet
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Default constructor. 
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: set content type
		response.setContentType("text/html");
		// Step 2: get the printwriter
		PrintWriter out = response.getWriter();
		// Step 3: Do whatever
		String userType = request.getParameter("userType");
		String userName = request.getParameter("userName");
		String password1 = request.getParameter("password1");
		System.out.println("chk1");
		if (userName == null || userName.equals("")){
			out.print("Username missing");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request,response);
			System.out.println("chk2a");
		}
		else if (password1 == null || password1.equals("")) {
			out.print("Password missing");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request,response);
			System.out.println("chk2b");
		}
		else {
			System.out.println("employee page linked");
			if (userType.equals("Employee")){
				System.out.println("Employee logging in");
				try {
					Connection conn = ConnectionFactory.getConnection();
					System.out.println("Getting connection");
					//Get connection
					String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_NAME=? AND EMPLOYEE_PASSWORD=?";
					//Execute statement
					PreparedStatement stmt = conn.prepareStatement(sql);
					//stmt = conn.prepareStatement(sql);
					System.out.println("statement prepared");
					System.out.println(userName + "" + password1);
					stmt.setString(1,  userName);
					stmt.setString(2, password1);
					System.out.println(stmt.toString());
					ResultSet rs = stmt.executeQuery();
					// Calls next, always true if a next exists
					if (rs.next()) {
						if (rs.getString("EMPLOYEE_POSITION").equals("Employee")) {
							RequestDispatcher rd = request.getRequestDispatcher("./Employee/mainEmployee.html");
							rd.forward(request,response);
						}
						else {
							RequestDispatcher rd = request.getRequestDispatcher("index.html");
							rd.forward(request,response);
						}
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("index.html");
						rd.forward(request,response);
					}
					RequestDispatcher rd = request.getRequestDispatcher("index.html");
					rd.forward(request,response);
				}catch (SQLException e)	{
					e.printStackTrace();
				}
			}
			else if (userType.equals("Manager")){
				try {
					Connection conn = ConnectionFactory.getConnection();
					// Get connection
					String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_NAME=? AND EMPLOYEE_PASSWORD=?";
					// Execute statement
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1,  userName);
					stmt.setString(2, password1);
					ResultSet rs = stmt.executeQuery();
					// Calls next, always true if a next exists
					if (rs.next()) {
						if (rs.getString("EMPLOYEE_POSITION").equals("Manager")) {
							RequestDispatcher rd = request.getRequestDispatcher("./Manager/mainManager.html");
							rd.forward(request,response);
						}
						else {
							RequestDispatcher rd = request.getRequestDispatcher("index.html");
							rd.forward(request,response);
						}
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("index.html");
						rd.forward(request,response);
					}
					RequestDispatcher rd = request.getRequestDispatcher("index.html");
					rd.forward(request,response);
				} catch (SQLException e)	{
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Error in userType check");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
