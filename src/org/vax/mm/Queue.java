package org.vax.mm;

import java.util.Random;
import java.util.Vector;

public final class Queue {
	
	final  Vector<PlayerObject> objects = new Vector<PlayerObject>();
	private  Random random 	= new Random(Runtime.getRuntime().freeMemory()/System.currentTimeMillis()); 
	
	
	public void generateRandomAndAdd(int size){
	
		for (int i = 0; i < size; i++) {
			PlayerObject obj = new PlayerObject();
			generateObject(obj);
			objects.add(obj);
		}
	}

	private void generateObject(PlayerObject obj) {
		int type = random.nextInt(4)+1;
		obj.type = type; 
		obj.rseed = random.nextDouble(); 
	}
}
