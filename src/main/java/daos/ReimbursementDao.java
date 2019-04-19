package daos;

import java.util.List;

import beans.Reimbursements;

public interface ReimbursementDao {
	
	List<Reimbursements> getAllReimbursements();
	Reimbursements getReimbursementById(int id);
	Reimbursements addReimbursement(int cost, String desc);
}
