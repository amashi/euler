import java.math.BigInteger;
import java.util.List;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p/>
 * What is the largest prime factor of the number 600851475143 ?
 *
 * answer 71,839,1471,6857
 */
public class Problem3 {

    public static void main(String[] args) {

        BigInteger num = new BigInteger("600851475143");


        long d = 6857 * 71 * 839; 
        long dd = d * 1471;

        // 600851475143;

        List<Integer> primes = Sieve_Of_Eratosthenes(new BigInteger("1999999"));
       // if(primes.size() > 10001)
         //   System.out.println("\nthe prime is ->" + primes.get(10001));
        long sum = 0;
        Collections.sort(primes);
        for (int i = 0; i < primes.size(); i++)
        {
            Integer p = primes.get(i);
            System.out.println("p = " + p);
            sum += p;
        }

        System.out.println("sum = " + sum);


    }



    public static String factorise(long numm)                      // To calculate the prime factors of a number
    {
        long newnum = numm;                        // Initialise
        String newtext = "";
        long checker = 2;                          // First possible factor to check

        while (checker * checker <= newnum)         // See if it is worth looking further for factors
        {
            if (newnum % checker == 0)            // If the possible factor is indeed a factor...
            {
                newtext = newtext + checker;      // ...then record the factor
                newnum = newnum / checker;          //    and divide by it
                if (newnum != 1)                  //    then check whether it is not last...
                {
                    newtext = newtext + ".";      //    ...and if so prepare for the next
                }
            } else                                  // otherwise...
            {
                checker++;                        // try the next possible factor
            }
        }
        if (newnum != 1)                          // If there is anything left at the end...
        {                                      // ...this must be the last prime factor
            newtext = newtext + newnum;           //    so it too should be recorded
        }
        if (newtext.equals(Long.toString(numm)))                // If the only prime factor is the original...
        {
            newtext = "Prime: " + newtext;        // ...then note that it must have been prime.
        }

        return newtext;                           // Return the prime factors
    }


    /*
  1. Create a contiguous list of numbers from two to some integer n.
  2. Strike out from the list all multiples of two (4, 6, 8 etc.).
  3. The list's next number that has not been struck out is a prime number.
  4. Strike out from the list all multiples of the number you identified in the previous step.
  5. Repeat steps 3 and 4 until you reach a number that is greater than the square root of n.
  6. All the remaining numbers in the list are prime.

    */
    public static List<Integer> Sieve_Of_Eratosthenes(BigInteger upto) {
        int max = upto.intValue();
        //System.out.println("max = " + max);

        Vector<Integer> list = new Vector<Integer>(max);

        //fill in
        for (int i = 0; i < max; i++) {
            list.add(i);
        }

        //remove 2
        for (int i = 2; i < list.size(); i++) {
            Integer i1 =  list.get(i);
            if (i1 % 2 == 0) {
                list.remove(i);
            }
        }

        int lastPrimeIndex = 2;

        while (lastPrimeIndex < max) {
            int multiplier =  list.get(lastPrimeIndex);

            //start from the next on the lsit
            for (int i = lastPrimeIndex + 1; i < list.size(); i++) {
                Integer num =  list.get(i);

                if (num % multiplier == 0) {
                    list.remove(i);
                }
            }

            try {
                lastPrimeIndex++;
                list.get(lastPrimeIndex);
 //            System.out.println("Found Prime = " + list.get(lastPrimeIndex));

            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }

        }


    //    printSieve("Primes", list);

        return list; 
    }


    public static void printSieve(String what, List<Integer> list) {
        System.out.println(what);
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);

            if (i % 20 == 0) {
                System.out.println("");
            } else {
                System.out.print("-" + integer + "-");
            }
        }

    }

}
