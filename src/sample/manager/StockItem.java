package sample.manager;

public class StockItem {
	private float rentalPrice;
	private String title;
	private int itemID;
	
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
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(float rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
}
