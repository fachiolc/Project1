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
		String reimbursementID = request.getParameter("reimbursementID");
		String requestAmount = request.getParameter("requestAmount");
		String requesterID = request.getParameter("requesterID");
		String requestDescription = request.getParameter("requestDescription");
		String status = "pending";
		System.out.println(reimbursementID +" "+  requestAmount +" "+ requesterID +" "+ requestDescription +" "+ status);
		ReimbursementDaoImpl dao = new ReimbursementDaoImpl();
			Reimbursements submitRequest = dao.addReimbursement(reimbursementID,requestAmount,requesterID,requestDescription, status);
			response.sendRedirect("../../Project1_1/Employee/viewReimbursements.html");
		
		
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
