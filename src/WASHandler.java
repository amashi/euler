import java.util.Random;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class WASHandler implements Callable<Boolean>{

	ExecutorService timeoutManager = Executors.newSingleThreadExecutor(); 
	
	
	static final int TIMEOUT = 290; 
	
	public static void main(String[] args) {
		WASHandler request = new WASHandler();
		
		try {
			request.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	private String executeTransaction(String param) {
		
 		if(!waitOnTransation()){
			//timeout, try another 
			
			if(!waitOnTransation()){
				//timeout 
				if(!waitOnTransation()){
					System.out.println("Thats it! no more :)");
				}
			}
		}
		
		return "success"; 
	}


	private boolean waitOnTransation() {
		CashTransation cashTran = new CashTransation(); 
		Future<String> submit = timeoutManager.submit(cashTran);
		String reply = new String(); 
		boolean rtVal = true; 
		
		try {
			
			reply = submit.get(TIMEOUT, TimeUnit.MILLISECONDS);
			System.out.println("Reply:" + reply);
			
		} catch (InterruptedException e) {
			rtVal = false; 
			e.printStackTrace();
		} catch (ExecutionException e) {
			rtVal = false; 
			e.printStackTrace();
		} catch (TimeoutException e) {
			
			rtVal = false; 
			
			e.printStackTrace();
		} 
		
		
		return rtVal; 
	}
	
	
	/*
	 
	 check one call, simulation for the was. 
	 time out 
	 */
	private void run() throws InterruptedException {
		Random rand = new Random();
		
		executeTransaction("run request"); 
	
		
		timeoutManager.shutdown();
	    // Wait until all threads are finish
	    while (!timeoutManager.isTerminated()) {
	    }
	    System.out.println("Finished all threads");
	    
	}
	
	
	@Override
    public Boolean call() throws Exception {
		executeTransaction("run request"); 
		timeoutManager.shutdown();
	    // Wait until all threads are finish
	    while (!timeoutManager.isTerminated()) {
	    }
	    System.out.println("Finished all threads");
		
		return true; 
	}
	
}
