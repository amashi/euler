import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;


public class Worker extends Thread{

	ConcurrentHashMap<String, Integer> cMap; 
	Random rand = new Random();
	
 	public Worker(ConcurrentHashMap<String, Integer> cMap, String param) {
 		this.cMap = cMap; 
	}

 
	@Override
	public void run() {

		
		for (int i = 1; i <= 100; i++) {
			try {
				System.out.println(getName() + ": "  + i);
				
				/*
				if(cMap.containsKey(getName())){
					Integer num = cMap.get(getName());
					cMap.put(getName(), i+num); 
				}else
					cMap.put(getName(), i);
				*/
				
				Thread.sleep(Math.abs(rand.nextInt() % 300));
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
		}
		
	}

}
