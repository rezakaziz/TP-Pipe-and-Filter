import java.util.List;

public class TransactionProcessor {
	private List<Client> clients;
	private List<StockItem> items;
	private List<RentedItem> rentedItems;
	
	public TransactionProcessor(List<Client> clients, List<StockItem> items, List<RentedItem> rentedItems){
		this.clients=clients;
		this.items=items;
		this.rentedItems=rentedItems;
		
	}
	
	public boolean CheckOut(StockItem i){
		return true;
	}
	public boolean CheckedIn(StockItem i){
		return true;
	}
	
	
	
	public boolean AddCustomer(Client c){
		return true;
	}
	public boolean AddStockItem(StockItem i){
		return true;
	}
	
}
