
import java.util.List;
import java.util.Scanner;
import java.lang.String;

public  class FilterA implements Runnable{
 
    public FilterA(Pipe<String> _dataINPipe, Pipe<Requete> _dataOUTPipe) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
	}

	Pipe<String> _dataINPipe;
    Pipe<Requete> _dataOUTPipe;
    
    
     
    public String getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( Requete tempData){
        _dataOUTPipe.dataIN(tempData);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}

	
	synchronized void execute() {
		// TODO Auto-generated method stub
		String s=_dataINPipe.dataOUT();
		System.out.println(s);
		String[] parts=s.split(" ");
		
		Requete req=new Requete(parts);
		_dataOUTPipe.dataIN(req);
		

		
	}
	
	
	
}
 