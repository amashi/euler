import java.util.TreeSet;
import java.util.Iterator;

/**


2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest number that is evenly divisible by all of the numbers from 1 to 20?


 */
public class Problem5{

    public static void main(String[] args) {

        int numbers[] = new int[20];
        for (int i = 0; i < 20; i++) {
            numbers[i] = i+1;
        }

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
        }

        TreeSet<String> founds = new TreeSet<String>();
        
        for(long i = 100; i < 300000000; i++)
        {
            for (int j = 0; j < numbers.length; j++) {
                int multiplier = numbers[j];

                if(i % multiplier == 0)
                {
                    if(j+1 == 20)
                        founds.add(Long.toString(i));
                }
                else
                    break; 
            }
        }

        for (Iterator<String> stringIterator = founds.iterator(); stringIterator.hasNext();) {
            String s = stringIterator.next();
            System.out.println(s);
        }
    }

}
