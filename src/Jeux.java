
public class Jeux extends StockItem {
	private String platform;
	public Jeux(float rentalPrice,String title,int itemID, String platform){
		super(rentalPrice,title,itemID);
		this.platform=platform;
	}
}
