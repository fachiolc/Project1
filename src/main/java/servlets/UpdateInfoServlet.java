package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionFactory;

/**
 * Servlet implementation class UpdateInfoServlet
 */
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set content type:
		response.setContentType("text/html");
		// get printwriter:
		PrintWriter out = response.getWriter();
		String newPassword = request.getParameter("password");
		String employee_name = request.getParameter("userName");
		// 
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_NAME=?";
			// Execute
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,  employee_name);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			ResultSet rs = 

		} catch (SQLException e) {
			e.printStackTrace();
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
