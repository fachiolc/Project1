package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Reimbursements;
import daos.ReimbursementDaoImpl;

/**
 * Servlet implementation class SubmitReimbursement
 */
public class SubmitReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitReimbursement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeid = request.getParameter("requesterID");
		String amount = request.getParameter("requestAmount");
		String description = request.getParameter("requestDescription");
		String status = "pending";
		
		ReimbursementDaoImpl dao = new ReimbursementDaoImpl();
			Reimbursements submitRequest = dao.addReimbursement(employeeid,amount,description,status);
			response.sendRedirect("viewReimbursements.html");
		
		
		// Step 1: set content type
//		response.setContentType("text/html");
		// Step 2: printwriter
//		Printwriter out = response.getWriter();
		// Step 3: get attributes
//		String cost = request.getParameter("Cost");
//		String description = request.getParameter("Description");
//		System.out.println(cost + description);
//		int id = (int) request.getAttribute("employee");
		// Access DAO
//		ReimbursementDaoImpl temp = new ReimbursementDaoImpl();
//		Reimbursements attempt = temp.addReimbursement(id, cost, description);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
