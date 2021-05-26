package sample.manager;

public class Client {
	private int accountBalance;
	private String name;
	private int customerID;
	
	public Client(int accountBalance,String name,int customerID){
		this.accountBalance=accountBalance;
		this.name=name;
		this.customerID=customerID;
	}
	
	public int getAccountBalance(){
		return this.accountBalance;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getCustomerID(){
		return this.customerID;
	}

	public void setAccountBalance(int accountBalance){
		this.accountBalance=accountBalance;
	}
	
	public void setName(String name){
		this.name=name;
	}
}
