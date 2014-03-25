package org.vax.mm;

import java.util.Random;
import java.util.Vector;

class Battle{
	int activeCount = 30; 
	int activeTime  = 0; 
}

public class BattleSim implements Runnable{
	private  Random random 	= new Random(Runtime.getRuntime().freeMemory()/System.currentTimeMillis()); 
	
	public static final int MAX_TIMEOUT = 60 * 1000 * 2;
	public static final int INTERVAL = 2500;
	public static final int MAX_DROP = 4;
	MMSim timeMng = null; 

	Vector<Battle> battles = new Vector<Battle>(); 
	
	public BattleSim(MMSim timeMng) {
		this.timeMng = timeMng;
		System.out.println("Init battle sim");
	}

	synchronized void startNewBattle(){
		System.out.println("MM startNewBattle()");
		battles.add(new Battle()); 
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(INTERVAL);
				int valDrops = 0; 
				int inBattles = 0; 
				//calculate drop outs.
				Vector<Integer> toDelete = new Vector<Integer>();
				
				
				synchronized(battles){
					for(Battle bat : battles){
						if(bat.activeCount <=0) continue; 
						
						int drop = random.nextInt(MAX_DROP);  
						bat.activeCount -= drop; 
						bat.activeTime += INTERVAL;
						int indexOf = battles.indexOf(bat); 
						//incase of game timeout. 5mn per game 
						if(bat.activeTime >= MAX_TIMEOUT){
							System.out.println("game over by timeout");
							valDrops += bat.activeCount; 
							bat.activeCount = -1; 
							toDelete.add(indexOf);
							
						}else if(bat.activeCount <= 1){
							System.out.println("game over by user");
							toDelete.add(indexOf);
						}
						
						inBattles += bat.activeCount; 
						valDrops += drop; 
					}
					
					//remove from battles. 
					for(Integer index : toDelete){
						System.out.println("deleting battle from queue idx:" + index);
						battles.remove(index); 
					}
					
					System.out.println(" -> > " + inBattles + " In Battles. Num of Battles:" + battles.size());
				}
				
				if(battles.size() > 0){
					System.out.println("returned to base pool from all battles: " + valDrops);
					timeMng.addToActivePool(valDrops); 
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		 }
	}
	
}
