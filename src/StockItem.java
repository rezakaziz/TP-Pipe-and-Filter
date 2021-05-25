
public class StockItem {
	private float rentalPrice;
	private String title;
	private int itemID;
	
	public StockItem(String title){
		this.itemID=itemID;
		this.title=title;
		this.rentalPrice=rentalPrice;
	}
	public StockItem(float rentalPrice,String title,int itemID){
		this.itemID=itemID;
		this.title=title;
		this.rentalPrice=rentalPrice;
	}

	public int getItemID() {
		// TODO Auto-generated method stub
		return this.itemID;
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}
	public int hashCode(){
		return this.title.hashCode();
	}
	public boolean equals(StockItem i){
		return i.getTitle()==this.title;
		
	}
}
