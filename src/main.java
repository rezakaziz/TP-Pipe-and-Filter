import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author Administrateur
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="0 0 12-12-2020 0";
		
		String s3="11";
		List<Client> clients=new LinkedList<Client>();
		List<StockItem> items=new LinkedList<StockItem>();
		List<RentedItem> rentedItems=new LinkedList<RentedItem>();
		
		Film item1=new Film((float)120.0,"Ahlil",0,"LotfiL'acteur");
		items.add(item1);
		
		Client c1=new Client(20000,"Rezak",0);
		clients.add(c1);
		
		Pipe<String> p=new PipeQueue<String>();
		p.dataIN(s);
		
		p.dataIN(s3);
		Pipe<Requete> p2=new PipeQueue<Requete>();
		FilterA f=new FilterA(p,p2);
		Pipe<String> p3=new PipeQueue<String>();
		FilterA2 f2=new FilterA2(p2,p3,clients,items,rentedItems);
		
		f.execute();
		f2.execute();
		
		f.execute();
		f2.execute();
		System.out.println("haha");

	}

}
