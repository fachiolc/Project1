package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import beans.Reimbursements;
import util.ConnectionFactory;

public class ReimbursementDaoImpl implements ReimbursementDao{

	@Override
	public List<Reimbursements> getAllReimbursements() {
		List<Reimbursements> reimbursements = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			// Get connection 
			Statement stmt = conn.createStatement();
			// Execute statement
			ResultSet rs = stmt.executeQuery("SELECT * FROM REIMBURSEMENTS");
			// Populate list from ResultSet
			while (rs.next()) {
				reimbursements.add(new Reimbursements(rs.getInt("REIMBURSEMENTS_ID"), rs.getString("REIMBURSEMENTS_REQUESTER"), rs.getString("REIMBURSEMENTS_AMOUNT"), rs.getString("REIMBURSEMENTS_DESCRIPTION"), rs.getString("EMPLOYEE_STATUS"),rs.getString("EMPLOYEE_MANAGER")));
			}
			System.out.println("Connected");
			return reimbursements;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursements getReimbursementById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements addReimbursement(int cost, String desc) {
		List<Reimbursements> reimbursements = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE TABLE REIMBURSEMENTS "
					+ "SET REIMBURSEMENT_REQUESTER = " + ",REIMBURSEMENT_AMOUNT = " + "REIMBURSEMENT_DESCRIPTION = " + "REIMBURSEMENT_STATUS=PENDING" + "REIMUBERSEMENTS_MANAGER = NULL");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
