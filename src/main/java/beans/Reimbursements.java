package beans;

public class Reimbursements 
{
	private int id;
	private String requester;
	private String amount;
	private String descriptions;
	private String status;
	
	public Reimbursements(int id, String requester, String amount, String descriptions, String status) {
		super();
		this.id = id;
		this.requester = requester;
		this.amount = amount;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
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
