import java.io.Console;

/**
 * Created by IntelliJ IDEA.
 * User: erez
 * Date: Jun 16, 2009
 * Time: 7:23:32 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * The following iterative sequence is defined for the set of positive integers:
 * <p/>
 * n ? n/2 (n is even)
 * n ? 3n + 1 (n is odd)
 * <p/>
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 ? 40 ? 20 ? 10 ? 5 ? 16 ? 8 ? 4 ? 2 ? 1
 * <p/>
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem),
 * it is thought that all starting numbers finish at 1.
 * <p/>
 * Which starting number, under one million, produces the longest chain?
 * <p/>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Problem14 {

    public static void main(String[] args)
    {
        int upTo = 1000000;
        int bigN = 1;
        int bigNs = 1;

        for (int i = 1; i < upTo; i++)
        {
//            System.out.print("[" + i + "]");
            long c = i;
            int s = 1;
            while (c > 1)
            {
                if (c % 2 == 0)
                    c = c / 2;
                else
                    c = (3 * c) + 1;
//                System.out.print("->" + c);
                s++;
            }
//            System.out.println("\nSequence size=" + s);
            if (s > bigNs)
            {
                bigNs = s;
                bigN = i;
//                System.out.println("new biggy =" + i + " seq=" + s);
            }
        }
        System.out.println("Biggest sequence up to " + upTo + " = " + bigN + " seq size = " + bigNs);
        printCollatzSeq(bigN);

    }

    public static void printCollatzSeq(long c)
    {
        System.out.print(c);
        int n = 1;
        while (c > 1)
        {
            if (c % 2 == 0)
                c = c / 2;
            else
                c = 3 * c + 1;
            System.out.print("->" + c);
            n++;
        }

        System.out.println("\nsequence=" + n);
    }


    public static void SieveOfEratosthenes_Problem10()
    {
        int limit = 1000000;
        int currentIndex = 2;
        int factor = 2;
        int factorLimit;
        int primes[] = new int[limit];

        //init...
        primes[0] = 2;
        primes[1] = 3;
        for (int i = currentIndex; i < limit; i++)
        {
            primes[i] = primes[i - 1] + 1;
        }

        factorLimit = (int) Math.floor(Math.sqrt((double) limit));
        System.out.println("factorLimit = " + factorLimit);

        for (factor = 2; factor <= factorLimit; factor++, currentIndex++)
        {
            for (int i = currentIndex; i < primes.length; i++)
            {
                Integer x = primes[i];
                if (primes[i] != 0 && x % factor == 0)
                {
                    primes[i] = 0; //assing 0
                }
            }
        }

        int i = 1;
        for (int prime : primes)
        {

            if (prime != 0)
            {
                System.out.print(" " + prime);
                i++;
            }

            if (i % 15 == 0 && prime != 0)
                System.out.println("");
        }
        System.out.println("Total primes ->" + i + " Up to " + limit);
    }


  
}
