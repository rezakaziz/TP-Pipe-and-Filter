package sample.manager;

public abstract class Pipe<I>{
 
   
	abstract public  void dataIN (I in);
     
	abstract public I dataOUT ();
 
}