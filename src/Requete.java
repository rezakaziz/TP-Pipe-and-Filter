
public class Requete {
	private String requete;
	private String[] parameters;
	public Requete(String[] s){
		this.requete=s[0];
		this.parameters=s;
		System.out.println(s[1]);
	}
	public String getRequest(){
		return this.requete;
	}
	public String[] getParameters(){
		return this.parameters;
	}
}
