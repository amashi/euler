import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;


public class Problem30 {

	public static void main(String[] args) {
		Problem30 p = new Problem30();
		p.run();
	}


	
	

	//implement various quick sort. 
	private void run() {
		long seed = System.currentTimeMillis() % 49490321;
				
		Random rand = new Random(seed); 
		
		int array[] = new int[20];  
		
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10); 
		}
		
		for (int i : array) {
			System.out.println(i);
		}
		

		quickSort(array, rand); 
		
		createTreeRand(10, rand);
		
		
	}

	private int[] createTreeRand(int nSize, Random rand){
		int arr[] = new int[nSize];
		
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
		
		for (int i = 0; i < 100; i++) {
			int rInt = rand.nextInt(1000);
			tree.add(rInt);
			
		}
		System.out.println("tail set");
		SortedSet<Integer> tailSet = tree.headSet(100);
		for (Integer i : tailSet) {
			System.out.println(i);
		}

		System.out.println("all set");
		Iterator<Integer> iterator = tree.iterator();
		for (Integer integer : tree) {
			System.out.println(integer);
		}
		
		
		
		return arr; 
	}



	private void quickSort(int[] array, Random rand) {
		
		
		
	
				
	}
}

















