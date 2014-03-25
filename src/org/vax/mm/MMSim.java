package org.vax.mm;

import java.util.Random;
import java.util.Timer;


public class MMSim implements Runnable {
	
	public static final float BASE_POOL = 10000;
	public static final float NEWPLAYERS = BASE_POOL / 100 * 2; 
	public static final float WILLING_TO_PLAY = 0.008f;
	public static final int INTERVAL = 2000;
	
	
	double wave = 1; 
	long timerTicks = 0; 
	Random random 	= new Random(Runtime.getRuntime().freeMemory()/System.currentTimeMillis()); 
	static boolean interupted = false; 
	float activePool = BASE_POOL; 
	
	public final QueueMng queueMng = new QueueMng(this); 
	public final BattleSim battleMng = new BattleSim(this); 
	
	
	public static void main(String[] args) {
		MMSim manager = new MMSim();
		manager.init();
		
		
		Thread runner = new Thread(manager);
		runner.start(); 
		
	}


	private void init() {
		Thread queueRunner = new Thread(queueMng);
		queueRunner.start(); 
		
		Thread battleRunner = new Thread(battleMng);
		battleRunner.start(); 
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				System.out.println("handle exit");
				interupted = true; 
			}
		}); 
	}

	synchronized void addToActivePool(float number){
		activePool += number; 
	}

	
	synchronized void removeFromActivePool(float number){
		activePool -= number; 
	}
	
	@Override
	public void run() {
		while(!interupted){
			try {
				timerTicks++; 
				//if(wave >= 90) wave = 1; 
				//int incoming = (int) (NEWPLAYERS * Math.sin(Math.toRadians(wave++)));
				//System.out.println("incoming:" + incoming);
				//addToActivePool(incoming); 
				
				System.out.println("on time interval |seconds passed:" + (INTERVAL * timerTicks / 1000));
				Thread.sleep(INTERVAL);

				float coef = random.nextFloat(); 
				float wtp = coef * WILLING_TO_PLAY ; 
				int playersGoingToPlay = (int) (activePool * wtp); 
				
				removeFromActivePool(playersGoingToPlay);
				
				
				if(activePool < 0){
					System.out.println("all players are active, exit no WTP");
					break; 
				}
				
				//addto queue 
				queueMng.addToQueue(playersGoingToPlay); 
				
				
				System.out.println("WTP:" + wtp + " | " + playersGoingToPlay + " pool:" + activePool);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
}
