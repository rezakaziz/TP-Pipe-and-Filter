package sample.manager;

import java.util.LinkedList;
import java.util.Queue;

public class PipeQueue<I> extends Pipe<I> {
   
 Queue<I> _inData = new LinkedList<I>();
 
 public synchronized  void dataIN (I in){
     _inData.add(in);
     notify(); 
 }
     
 public synchronized I dataOUT (){
	 if(_inData.isEmpty())
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return _inData.poll();
 }
	 
}