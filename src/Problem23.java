import java.util.Arrays;
import java.util.Vector;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: erez
 * Date: Jun 20, 2009
 * Time: 1:40:51 AM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
 * which means that 28 is a perfect number.
 * <p/>
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 * <p/>
 * As 12 is the smallest abundant number,
 * 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
 * However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest
 * number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 * <p/>
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class Problem23 {


    public static void main(String[] args)
    {
        long start = System.nanoTime();

        Problem23_3();

        long time = System.nanoTime() - start;
        System.out.println("\nTime in seconds " + (double) time / 1000000000);
    }

    public static void Problem23_3()
    {
        int result = 0;
        int[] numbers = new int[28123];
        ArrayList<Integer> abundants = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i + 1;
            //sum up all numbers...
            result += numbers[i];

            //collect abundants
            if (isAbundant(numbers[i]))
            {
                abundants.add(numbers[i]);


            }
        }

        for (int i = 0; i < abundants.size(); i++)
        {
            for (int j = i; j < abundants.size(); j++)
            {
                int a1 = abundants.get(i);
                int a2 = abundants.get(j) - 1;
                int index = a1 + a2;
                // System.out.println(a1 + "+" + a2 + "=" + index);


                if (index < numbers.length)
                {
                    result -= numbers[index];
                    numbers[index] = 0;
                }
            }
        }

        System.out.println(result);

    }

    public static boolean isAbundant(int n)
    {
        int sum = 0;

        /*
        for (int i = 1; i < n; i++)
        {
            if (n % i == 0)
            {
                sum += i;
            }
        }

        if(sum != sumProperDivisors(n))
        {
            System.out.print("isAbundant(" + n + ") = " + sum);
            System.out.println(" ---!=---- sumProperDivisors(" + n + ") = " + sumProperDivisors(n));
        }
        */
        if (n == 1) return false;

//        sum = (int) sumProperDivisors(n);
        sum = (int) sumDivisors(n)-n;

        return sum > n;
    }


    public static void Problem23()
    {
        long start = System.nanoTime();
        long result = 0;
        int c = 0;
        Vector<Integer> abNum = new Vector<Integer>();
        abNum.add(12);
        for (int n = 13; n <= 20200; n++)
        {
            long sum = sumProperDivisors(n);
            if (sum > n)
            {
//                System.out.println("Abundant Number=" + n + " + " + (n - abNum.lastElement()) + " from last");
                abNum.add(n);

//                if(n % 2 !=0 )
//                    System.out.println("Abundant Number=" + n + " + " + (n - abNum.lastElement()) + " from last");

                c++;
            }
        }

        //http://planetmath.org/?op=getobj&from=objects&id=10187
        //evern n even > 70 can be a+b (abundants...)
        //trim out 0
        // all evens > 70...
        //from wikipedia
        // Also, every integer greater than 20161 can be written as the sum of two abundant numbers! ...
        //maybe the math analysis has reduced it a bit...

        int[] nonAb = new int[20200];
        for (int i = 0; i < nonAb.length; i++)
        {
            nonAb[i] = i + 1;
        }


        //remove odd numbers over 70
        for (int i = 0; i < nonAb.length; i++)
        {
            if (nonAb[i] % 2 == 0 && i > 70)
            {
                nonAb[i] = 0; //remove = 0
            }
        }


        //start scan from 24 - as minimum ab = 12...
        for (int i = 23; i < nonAb.length; i++)
        {
            int n = nonAb[i];
            if (n != 0)
            {
                if (isSumEqual(abNum, n))
                    nonAb[i] = 0;
//                else
//                    System.out.println("Non Abundant Summable Number = " + n);
            }
        }


        //add all != 0..
        int x = 1;
        for (int n : nonAb)
        {
            if (n != 0)
            {
                System.out.println(n + " n=" + x++);
                result += n;
            }
        }


        //trim out all evens > 70...
        //start from 25

//        int n = 0;
//        for (Integer ab : abNum)
//        {
//            if (n < abNum.size() - 1)
//                System.out.println(abNum.get(n + 1) + "-" + ab + " = " + (abNum.get(n + 1) - ab));
//            System.out.println(ab);
//            if (ab % 2 != 0)
//                System.out.println("Odd ab=" + ab);
//            n++;
//        }


        System.out.println("Ab Numbers = " + c);
        System.out.println("result=" + result);


//        for(int i = 2; i < 9000; i++)
//        {
//            Integer[]l = theNthUnorderedPermutation(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, i);
//            System.out.println(Arrays.toString(l) + " i=" + i);
//        }
    }

    //first prime...
    /*
    if n < 945 (then no Odd)
    so odd integers less are not sum equal...
    above 945 -
    abs numbers end in 2 - 4 - 6 and 5, ODD end result integer could be 1 - 5 - 7 - 9
     so 3 Odd could not be summed as 2 abundands.. anywhere .

     */
    public static boolean isSumEqual(Vector<Integer> list, int n)
    {
//        int fP = list.indexOf(945);
        if (n < 945 && n % 2 != 0)
            return false;
        else if ((n - 3) % 10 == 0) //if end in 3 return false...
            return false;
        else if (n <= 70)
        {
            int a = list.indexOf(70);
            for (int z = 0; z <= a; z++)
            {
                for (int p = 0; p <= a; p++)
                {
                    int a1 = list.get(z);
                    int a2 = list.get(p);
                    if (a1 + a2 == n)
                    {
                        System.out.println("Integer sum Equals " + a1 + "+" + a2 + " = " + (a1 + a2));
                        return true;
                    }
                }
            }
        }
        else //all the rest of the numbers...
        {
            int a = findClosestIndex(list, n);
            for (int z = 0; z <= a; z++)
            {
                for (int p = 0; p <= a; p++)
                {
                    int a1 = list.get(z);
                    int a2 = list.get(p);
                    if (a1 + a2 == n)
                    {
//                        System.out.println("Sumable " + a1 + "+" + a2 + " = " + (a1 + a2));
                        return true;
                    }
                }
            }
//            System.out.println("NON sumable=" +n );


        }

        return true;
    }

    private static int findClosestIndex(Vector<Integer> list, int n)
    {
//        System.out.println("n = " + n);
        for (int i = 0; i < list.size(); i++)
        {
            // 957 > (945 +12)
            Integer a = list.get(i);
            if (a >= n + 12)
            {
                return i;
            }
        }
        return list.size() - 1;
    }


    public static long sumProperDivisors(long n)
    {
        long sum;
        long f = 2;
        long r = (int) Math.floor(Math.sqrt(n));
        //first take into account the case that n is a perfect square
        if (r * r == n)
        {
            sum = 1 + r;
            r = r - 1;
        }
        else
            sum = 1;

        if (n % 2 != 0) //if Odd number, cannot have even divisors!
            f = 3;

        while (f <= r)
        {
            if (n % f == 0)
                sum += f + (n / f);
            f++;
        }

        return sum;
    }

    /*
        can be used to test is prime..    this faster then sumProperDivisors()
    */
    public static long sumDivisors(int n)
    {
        /*
        long sum = 1;
        int p = 2;

        while (p * p <= n && n > 1)
        {
            if (n % p == 0)
            {
                long j = p * p;
                n /= p;
                while (n % p == 0)
                {
                    j *= p;
                    n /= p;
                }
                sum *= j - 1;
                sum /= p - 1;
            }
            if (p == 2)
                p = 3;
            else
                p += p + 2;
        }
        if (n > 1)
            sum *= n + 1;

        return sum;
        */
        int prod = 1;
        for (int k = 2; k * k <= n; ++k)
        {
            int p = 1;
            while (n % k == 0)
            {
                p = p * k + 1;
                n /= k;
            }
            prod *= p;
        }

        if (n > 1)
            prod *= 1 + n;

        return prod;
    }


    public static <E> E[] theNthPermutation(E[] s, int num)
    {
        // s is the input elements array and num
        // is the number which represents the permutation

        int factorial = 1;
        for (int i = 2; i < s.length; i++)
            factorial *= i; // calculates the factorial of (s.length - 1)

        if (num / s.length >= factorial) // Optional. if the number is not in the
            // range of [0, s.length! - 1]
            return null;

        for (int i = 0; i < s.length - 1; i++)
        {//go over the array

            // calculates the next cell from the cells left
            // (the cells in the range [i, s.length - 1])
            int tempi = (num / factorial) % (s.length - i);

            // Temporarily saves the value of the cell needed
            // to add to the permutation this time
            E temp = s[i + tempi];

            // shift all elements to "cover" the "missing" cell
            for (int j = i + tempi; j > i; j--)
                s[j] = s[j - 1];

            s[i] = temp; // put the chosen cell in the correct spot

            factorial /= (s.length - (i + 1)); // updates the factorial

        }

        return s;
    }


    /*
        Unordered generation

        For every number k, with 0 ? k < n!, the following algorithm generates a unique permutation 
        of the initial sequence sj, j = 1, …, n:

        The formula k mod j returns the least significant digit of k in the factorial base and k := k / j
        removes that digit, shifting the remaining digits to the right.
        The first line of the for loop, at each step, swaps the jth element with one of the elements
        that are currently before it.
        If we consider the swaps in reverse order, we see that it implements a backwards selection sort,
        first putting the nth element in the correct place, then the (n ? 1)th, etc.
        Since there is exactly one way to selection sort a permutation,
        this algorithm generates a unique permutation for each choice of k.
     */
    public static <E> E[] theNthUnorderedPermutation(E[] s, int k)
    {
        for (int j = 2; j < s.length; j++)
        {
            int t = (k % j) + 1;
            s[t] = s[j];

            k = k / j;
            System.out.println("k = " + k + " t=" + t);
        }

        return s;
    }


    public static void Problem23_2()
    {
        long total = 0;
        boolean canBeWritten = true;
        int counter = 0;
        int[] abundantNumbers = new int[6966];
        int[] numbersWrittenByAbundant = new int[99999];

        for (int i = 1; i < 28123; i++)
            if (sumOfDivisors(i) > i)
                abundantNumbers[counter] = i;

        System.out.println("Abundant Numbers Stored");
        counter = 0;

        for (int i = abundantNumbers.length - 1; i > 0; i--)
        {
            numbersWrittenByAbundant[counter] = abundantNumbers[i] - abundantNumbers[i - 1];
            counter++;
        }

        System.out.println("sum of two abundant numbers stored");

        for (int i = 0; i <= 28123; i++)
        {
            for (int aNumbersWrittenByAbundant : numbersWrittenByAbundant)
            {
                if (i == aNumbersWrittenByAbundant)
                {
                    canBeWritten = true;
                    break;
                }
                else canBeWritten = false;
            }
            if (!canBeWritten)
                total += i;
        }
        System.out.println(total);
    }


    public static long sumOfDivisors(long number)
    {
        int sum = 0;
        for (long i = 1; i <= number / 2; i++)
            if (number % i == 0)
                sum += i;
        return sum;
    }
}
