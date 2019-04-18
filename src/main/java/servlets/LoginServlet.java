package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet implementation class LoginServlet
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Default constructor. 
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	 // @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Step 1: set content type
		response.setContentType("text/html");
		// Step 2: get the printwriter
		PrintWriter out = response.getWriter();
		// Step 3: Do whatever
		String userType = request.getParameter("userType");
		String userName = request.getParameter("userName");
		String password1 = request.getParameter("password1");
		System.out.println("chk1");
		if (userName == null || userName.equals(""))
		{
			out.print("Username missing");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request,response);
			System.out.println("chk2a");
		}
		else if (password1 == null || password1.equals(""))
		{
			out.print("Password missing");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request,response);
			System.out.println("chk2b");
		}
		else 
		{
			System.out.println("employee page linked");
			if (userType.equals("Employee"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("./Employee/mainEmployee.html");
				rd.include(request,response);
			}
			else if (userType.equals("Manager"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("./Manager/mainManager.html");
				rd.include(request,response);
			}
			else 
			{
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
