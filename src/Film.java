
public class Film extends StockItem {
	private String acteur;
	public Film(float rentalPrice,String title,int itemID, String acteur){
		super(rentalPrice,title,itemID);
		this.acteur=acteur;
	}
	
	public String getActor(){
		return this.acteur;
	}
}
