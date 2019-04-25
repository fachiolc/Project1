package beans;

public class Reimbursements 
{
	private int id;
	private String requester;
	private String cost;
	private String descriptions;
	private String status;

	
	public Reimbursements(int id, String cost, String requester, String descriptions, String status) {
		super();
		this.id = id;
		this.cost = cost;
		this.requester = requester;
		this.descriptions = descriptions;
		this.status = status;

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRequester() {
		return requester;
	}
	public void setRequester(String requester) {
		this.requester = requester;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
