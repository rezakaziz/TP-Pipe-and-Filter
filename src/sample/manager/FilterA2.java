package sample.manager;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public  class FilterA2 implements Runnable {
 
    public FilterA2(Pipe<Requete> _dataINPipe, Pipe<String> _dataOUTPipe, List<Client> clients, List<StockItem> items, List<RentedItem> rentedItems) {
		
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
		String[] parameters1;
		switch(req.getRequest()){
			case "0":
				parameters1=req.getParameters();
				LocationItem(this.items.get(Integer.parseInt(parameters1[1])),parameters1[2],this.clients.get(Integer.parseInt(parameters1[3])));
				break;
			case "1":
				this.RemiseItem(0);
					break;
			case "2":
				//Ajout Pénalité
				System.out.println("Requte 2");
					break;
			case "3":
				//Find By title
				StockItem i=this.FindByTitle(req.getParameters()[1]);
				System.out.println("Requte 3");
				System.out.println(i.getTitle());
					break;
			case "4":
				//add film
				parameters1=req.getParameters();
				
				StockItem film=new Film(Float.parseFloat(parameters1[1]), parameters1[2],Integer.parseInt(parameters1[3]), parameters1[4]);
				this.AddStockItem(film);
				System.out.println(this.items.get(0).getTitle()+ " " +this.items.get(1).getTitle());
					break;
			case "5":
				//add jeux
				parameters1=req.getParameters();
				
				StockItem j=new Jeux(Float.parseFloat(parameters1[1]), parameters1[2],Integer.parseInt(parameters1[3]), parameters1[4]);
				this.AddStockItem(j);
				System.out.println(this.items.get(0).getTitle()+ " " +this.items.get(1).getTitle());
				//StockItem i=this.FindByTitle(req.getParameters()[1]);
				
					break;
			case "6":
				//ajouter un client
				parameters1=req.getParameters();
				Client c=new Client(Integer.parseInt(parameters1[1]),parameters1[2] , Integer.parseInt(parameters1[3]));
				this.AddCustomer(c);
				System.out.println("Requte 6");
				System.out.println(this.clients.get(1).getName());
				
				
					break;
			case "7":
				///Filtrer les films d'un acteur
				parameters1=req.getParameters();
				List<Film> l=this.FindByActor(parameters1[1]);
				System.out.println("Requte 7");
				System.out.println(l.get(0).getActor());
					break;
			case "8":
				///if an item is checked out
				parameters1=req.getParameters();
				StockItem item=this.FindByTitle(parameters1[1]);
				this.IsCheckedOut(item);
				System.out.println("Requte 8");
				System.out.println(this.IsCheckedOut(item));
				
					break;
			case "9":
				//films qu'un un client a louer
				parameters1=req.getParameters();
				Client c2=this.clients.get(Integer.parseInt(parameters1[1]));
				List<Film> films=this.FilmLouerPar(c2);
				System.out.println("Requte 9");
				System.out.println(films.get(0).getActor());
				
				
					break;
			case "10":
				///solde client
				parameters1=req.getParameters();
				Client c3=this.clients.get(Integer.parseInt(parameters1[1]));
				float solde=this.Solde(c3);
				System.out.println("Requte 10");
				System.out.println(solde);
				
					break;
			case "11":
				///overdue
				parameters1=req.getParameters();
				
			try {
				List<StockItem> overdues=this.ListOverDueItem();
				System.out.println("Requte 11");
				System.out.println(overdues.get(0).getTitle());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				

					break;
		
		}
		
		

		
	}
	
	/**
	 * Fonction 0
	 * Louer Un article i au client c
	 * @param i
	 * @param c
	 * @return
	 */
	public boolean LocationItem(StockItem i, String d, Client c){
		RentedItem r=new RentedItem(i.getItemID(),d,c.getCustomerID());
		this.rentedItems.add(r);
		return true;
	}
	/**
	 * Fonction 1
	 * @param itemID
	 * @return
	 */
	public boolean RemiseItem(int itemID){
		int ind=-1;
		for(int i=0;i<this.rentedItems.size();i++){
			if (this.rentedItems.get(i).getItemID()==itemID){
				ind=i;
				break;
			}
		}
		RentedItem r=this.rentedItems.get(ind);
		this.rentedItems.remove(r);
		return true;
	}
	
	/**
	 * Fonction 2
	 * @param c
	 * @return
	 */
	
	public boolean penaliteAjout(Client c){
		return true;
	}
	/**
	 * Fonction 4
	 * @param i
	 * @return
	 */
	public boolean AddStockItem(StockItem i){
		this.items.add(i);
		return true;
	}
	
	
	/**
	 * Fonction 5
	 * @param c
	 * @return
	 */
	public boolean AddCustomer(Client c){
		this.clients.add(c);
		return true;
	}
	/**
	 * Fonction 3
	 * @param title
	 * @return
	 */
	public StockItem FindByTitle(String title){
		StockItem i=new StockItem(title);
		int ind=-1;
		for(int j=0;j<this.items.size();j++){
			if (this.items.get(j).getTitle().equals(title)){
				ind=j;
				break;
			}
		}
		if (ind==-1){
			return null;
		}
		return this.items.get(ind);
	}
	
	
	
	
	/**
	 * Fonction 6
	 * @param actor
	 * @return
	 */
	public List<Film> FindByActor(String actor){
		List<Film> l=new LinkedList<Film>();
		for(int i=0;i<this.items.size();i++){
			if (this.items.get(i) instanceof Film){
				if (((Film)this.items.get(i)).getActor().equals(actor)){
					
					l.add((Film)this.items.get(i));
					
				}
			}
			
		}
		return l;
	}
	
	public List<Film> FilmLouerPar(Client c){
		List<Film> l=new LinkedList<Film>();
		for(int i=0;i<this.rentedItems.size();i++){
			if (this.rentedItems.get(i).getCustomerID()==c.getCustomerID()){
				RentedItem r=this.rentedItems.get(i);
				StockItem s=this.items.get(r.getItemID());
				if (s instanceof Film){
					l.add((Film)this.items.get(i));
				}
			}
		}
		return l;
	}
	
	/**
	 * Fonction 7
	 * @param i
	 * @return
	 */
	public boolean IsCheckedOut(StockItem item){
		for(int i=0;i<this.rentedItems.size();i++){
			
			if (item.getItemID()==this.rentedItems.get(i).getItemID()){
				return true;
			}
		}
		return false ;
	}
	
	/**
	 * Fonction 8
	 * @param c
	 * @return
	 */
	public float Solde(Client c){
		return c.getAccountBalance();
	}
	
	/**
	 * Fonction 9
	 * @return
	 * @throws ParseException 
	 */
	public List<StockItem> ListOverDueItem() throws ParseException{
		List<StockItem> l = new LinkedList<StockItem>();
		for(int i=0;i<this.rentedItems.size();i++){
			Long millis = System.currentTimeMillis();
		    Date dateJour = new Date(millis);
		    
		    Date dueDate= new SimpleDateFormat("dd-MM-yyyy").parse(this.rentedItems.get(i).getdueDate());
		    System.out.println(dateJour.compareTo(dueDate));
			if (dateJour.compareTo(dueDate)==1){
				l.add(this.items.get(rentedItems.get(i).getItemID()));
			}
		}
		return l;
	}
	
}

 