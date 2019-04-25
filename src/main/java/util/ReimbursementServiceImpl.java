package util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Reimbursements;
import daos.ReimbursementDao;
import daos.ReimbursementDaoImpl;

public class ReimbursementServiceImpl implements ReimbursementService {
	
	private final ReimbursementDao dao = new ReimbursementDaoImpl();
	// Object mapper to turn Reimbursement object into JSON
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public List<Reimbursements> getAllReimbursements(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ReimbursementServiceImpl");
		return dao.getAllReimbursements();
	}

	@Override
	public Reimbursements createReimbursement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
