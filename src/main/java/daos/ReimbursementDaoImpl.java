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
			System.out.println("ReimbursementDaoImpl - getAllReimbursements()");
			// Populate list from ResultSet
			while (rs.next()) {
				reimbursements.add(new Reimbursements(rs.getInt("REIMBURSEMENT_ID"), rs.getString("REIMBURSEMENT_COST"), rs.getString("REIMBURSEMENT_REQUESTER"), rs.getString("REIMBURSEMENT_DESCRIPTION"), rs.getString("REIMBURSEMENT_STATUS")));
				System.out.println("ReimbursementDaoImpl - getAllReimbursements - Added Reimbursement");
			}
			System.out.println("ReimbursementDaoImpl - getAllReimburesments - Connected");
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

//	@Override
//	public Reimbursements addReimbursement(int id, String cost, String desc) {
//		List<Reimbursements> reimbursements = new ArrayList<>();
//		try (Connection conn = ConnectionFactory.getConnection()) {
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("INSERT INTO REIMBURSEMENTS (REIMBURSEMENT_ID, REIMBURSEMENT_COST, REIMBURSEMENT_DESCRIPTION, REIMBURSEMENT_STATUS) VALUES('" +
//			id + "','" + cost + "','" + desc + "','pending')");
//			rs.next();
//			System.out.println(rs);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	public Reimbursements addReimbursement(String reimbursementID, String requestAmount, String requesterID, String requestDescription, String status) {
		
		List<Reimbursements> reimbursements = new ArrayList<>();
//		
		status = "pending";
		try (Connection conn = ConnectionFactory.getConnection()) {
			System.out.println("ReimbursementDaoImpl - Connected");
			Statement stmt = conn.createStatement();
			System.out.println("ReimbursementDaoImpl - Attempting to add reimbursement");
			int rs = stmt.executeUpdate("INSERT INTO REIMBURSEMENTS "
					+ "(REIMBURSEMENT_ID,  "
					+ "REIMBURSEMENT_COST, "
					+ "REIMBURSEMENT_REQUESTER, "
					+ "REIMBURSEMENT_DESCRIPTION, "
					+ "REIMBURSEMENT_STATUS) VALUES('" +
					reimbursementID + "','" + 
					requestAmount + "','" + 
					requesterID + "','" + 
					requestDescription + "','"
							+ "pending')");
			System.out.println("ReimbursementDaoImpl - Added reimbursement");
			//			rs.next();
			System.out.println(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
