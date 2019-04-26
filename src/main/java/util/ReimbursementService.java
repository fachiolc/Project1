package util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Reimbursements;

public interface ReimbursementService {
	List<Reimbursements> getAllReimbursements(HttpServletRequest request, HttpServletResponse response);
	Reimbursements addReimbursement(HttpServletRequest request, HttpServletResponse response);
}
