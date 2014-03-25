package org.vax.mm;

import java.util.Random;

public class QueueMng implements Runnable{

	private Random random = new Random(Runtime.getRuntime().freeMemory()/System.currentTimeMillis()); 
	public static final int INTERVAL = 500;
	
	static int queueSize = 0;

	int MM_MAX_WAIT = 15; 
	MMSim timeMng = null; 
	
	//will create a list of queues, once size is maxed
	Queue queue = new Queue(); 
	
	public QueueMng(MMSim timeMng) {
		this.timeMng = timeMng; 
	}


	synchronized void addToQueue(int wtf){
		//if(queueSize > 500) return; 
		queueSize += wtf;
		queue.generateRandomAndAdd(wtf); 
	}
		
	
	@Override
	public void run() {
		 while(true){
			try {
				System.out.println("queue mng timeout q size:" + queueSize);
				runMM();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		 }
	}


	private void runMM() throws InterruptedException {
		System.out.println("Match Making phase");
		
		
		//replace with MM -> proof 
		int wait = random.nextInt(MM_MAX_WAIT)+1;  
		Thread.sleep(wait * 1000);

		

		if(queueSize > 30){
			queueSize -= 30; 
			timeMng.battleMng.startNewBattle();
			System.out.println("**** Starting battle (waited for:" + wait + " sec)");
		}
		
		for(PlayerObject obj: queue.objects){
			
			//System.out.println(obj.rseed);
		}
		
	} 
	
	
	PlayerObject getRandomPlayer(){
		PlayerObject obj = null;
		
		int size = queue.objects.size(); 
	    int rand = random.nextInt(size);
		obj = queue.objects.elementAt(rand);
		
		return obj; 
	}
	
	
}
