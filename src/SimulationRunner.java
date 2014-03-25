import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class SimulationRunner {

	ExecutorService esb = Executors.newFixedThreadPool(30); 
	
	public static void main(String[] args) {
		
		 SimulationRunner runner = new SimulationRunner();
		 runner.run();
	}

	
	private void run() {
		for (int i = 0; i < 1000; i++) {
		WASHandler handle = new WASHandler();
			
			Future<Boolean> reply = esb.submit(handle);
			
		}
	}
}
