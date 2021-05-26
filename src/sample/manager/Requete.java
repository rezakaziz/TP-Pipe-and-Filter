package sample.manager;

public class Requete {
	private String requete;
	private String[] parameters;
	public Requete(String[] s){
		this.requete=s[0];
		this.parameters=s;
		
	}
	public String getRequest(){
		return this.requete;
	}
	public String[] getParameters(){
		return this.parameters;
	}
}
