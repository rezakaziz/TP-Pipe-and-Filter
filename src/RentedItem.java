
public class RentedItem {
	private int itemID;
	private String dueDate;
	private int customerID;
	
	public RentedItem(int itemID,String dueDate,int customerID){
		this.itemID=itemID;
		this.dueDate=dueDate;
		this.customerID=customerID;
	}

	public int getItemID() {
		// TODO Auto-generated method stub
		return this.itemID;
	}
	
	public String getCustomerID() {
		// TODO Auto-generated method stub
		return this.dueDate;
	}
	
	public int getdueDate() {
		// TODO Auto-generated method stub
		return this.customerID;
	}

}
