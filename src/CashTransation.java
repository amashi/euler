import java.util.Random;
import java.util.concurrent.Callable;


public class CashTransation implements Callable<String>{
	
	static final int MAXTIME = 300; 
	
	@Override
    public String call() throws Exception {
		Random rand = new Random();
		
		
		System.out.println("T-ID:" + Thread.currentThread().getId() + " : starting to work...");
		
		Thread.sleep(Math.abs(rand.nextInt() % MAXTIME));
       
		
		
		return "Task Completed for:T-ID:" + Thread.currentThread().getId();
    }
}
