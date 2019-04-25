package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import util.Dispatcher;

public class DispatcherServlet extends HttpServlet {
	// Create Object Mapper
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();
	// Initialize
	public DispatcherServlet() {

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DispatcherServlet started");
		// Set content type
		resp.setContentType("application/json");
		// getOutputStrean() because it will write the response more efficiently than getWriter().println()
		// mapper.writeValueAsBytes() converts whatever the Dispatcher returns into a byte[], which getOutputStream().write() accepts
		// Dispatcher.process() returns whatever resource we have available at the HttpServletRequest's URI
		resp.getOutputStream().write(mapper.writeValueAsBytes(Dispatcher.process(req, resp)));
		System.out.println("DispatcherServlet - Response sent successfully");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DispatcherServlet.doPost");
		resp.setContentType("application/json");
		resp.getOutputStream().write(mapper.writeValueAsBytes(Dispatcher.processPost(req, resp)));
		System.out.println("DispatcherServlet - Response sent successfully!");
	}
}


