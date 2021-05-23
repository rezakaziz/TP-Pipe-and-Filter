
import java.util.List;
import java.util.Scanner;
import java.lang.String;

public  class FilterA2 implements Runnable{
 
    public FilterA2(Pipe<Requete> _dataINPipe, Pipe<String> _dataOUTPipe,List<Client> clients,List<StockItem> items,List<RentedItem> rentedItems) {
		
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
		
		this.clients=clients;
		this.items=items;
		this.rentedItems=rentedItems;
	}

	Pipe<Requete> _dataINPipe;
    Pipe<String> _dataOUTPipe;
    
    private List<Client> clients;
	private List<StockItem> items;
	private List<RentedItem> rentedItems;
    
    
     
    public Requete getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}

	
	synchronized void execute() {
		// TODO Auto-generated method stub
		
		
		
		Requete req=_dataINPipe.dataOUT();
		switch(req.getRequest()){
			case "0":
				String[] parameters=req.getParameters();
				
				LocationItem(this.items.get(Integer.parseInt(parameters[1])),parameters[2],this.clients.get(Integer.parseInt(parameters[3])));
				
				break;
			case "1":
				System.out.println("Requte 1");
					break;
			case "2":
				System.out.println("Requte 2");
					break;
		
		}
		
		

		
		
		//dataINPipe.dataOUT()
		/*_dataOUTPipe.dataIN(s);
		_dataOUTPipe.dataIN("azerty2");
		_dataOUTPipe.dataIN("azerty3");
		_dataOUTPipe.dataIN("azerty4");*/
	}
	
	/**
	 * Louer Un article i au client c
	 * @param i
	 * @param c
	 * @return
	 */
	public boolean LocationItem(StockItem i,String d,Client c){
		RentedItem r=new RentedItem(i.getItemID(),d,c.getCustomerID());
		this.rentedItems.add(r);
		return true;
	}
	
	public boolean RemiseItem(int itemID){
		
		return true;
	}
	
	public boolean penaliteAjout(Client c){
		return true;
	}
	public boolean FindByTitle(String title){
		
		return true;
	}
	
	public boolean AddStockItem(StockItem i){
		return true;
	}
	
	public boolean AddCustomer(Client c){
		return true;
	}
	
	
	
	
	public List<StockItem> FindByActor(String actor){
		List<StockItem> l = null;
		return l;
	}
	
	public boolean IsCheckedOut(StockItem i){
		return true;
	}
	public float Solde(Client c){
		return (float)1.0;
	}
	public List<StockItem> ListOverDueItem(){
		List<StockItem> l = null;
		return l;
	}
	
	
	
	public boolean CheckOut(StockItem i){
		return true;
	}
	public boolean CheckedIn(StockItem i){
		return true;
	}
	
}

 