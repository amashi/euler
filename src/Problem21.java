import java.sql.Time;

/**
 * Created by IntelliJ IDEA.
 * User: erez
 * Date: Jun 19, 2009
 * Time: 2:51:27 PM
 * To change this template use File | Settings | File Templates.




Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ? b,
then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 
 */
public class Problem21 {

    public static void main(String[] args)
    {
     //Thabit rule. 
//    p = 3 × 2^(n ? 1) ? 1
//    q = 3 × 2^(n ? 1)
//    r = 9 × 2^(2n ? 1) ? 1
//    where n > 1 is an integer and p, q, and r are prime numbers,
//    then 2^n*pq and 2^n*r are a pair of amicable numbers.

      long start = System.nanoTime();
      for(int n = 1; n< 10000000; n++)
      {
//         int s= sumProperDivisors(n);

          long sum = sumDivisors(n) -n;
          if(sum == n)
              System.out.println("Perfect Number=" + n);
          else if(sum > n*2.597)
              System.out.println("Abundant Number=" + n + " Divisors sum=" + sum);

      }
      long time = System.nanoTime() - start;
        System.out.println("time in seconds " + (double)time / 1000000000);

    }

//Perfect Number=6
//Perfect Number=28
//Perfect Number=496
//Perfect Number=8128
//Perfect Number=130816
//Perfect Number=2096128
//Abundant Number=7464960 Divisors sum=19390050 (2.597)..


    /*
         can be used to test is prime..    this faster then sumProperDivisors()
     */
    public static long sumDivisors(int n)
    {
        long sum = 1;
        int p = 2;

        while(p*p <= n && n > 1)
        {
            if(n % p == 0)
            {
               long  j = p*p;
               n /= p;
               while(n % p == 0)
               {
                   j *= p;
                   n /= p; 
               }
               sum *= j-1;
               sum /= p-1; 
            }
            if(p == 2)
                p =3;
            else
                p += p+2;
        }
        if(n>1)
            sum *= n+1;

        return sum;
    }

    public static long sumProperDivisors(long n)
    {
        long sum;
        long f = 2;
        long r = (int) Math.floor(Math.sqrt(n));
        //first take into account the case that n is a perfect square
        if(r*r == n)
        {
            sum = 1+r;
            r=r-1; 
        }
        else
            sum =1;

        if(n % 2 != 0) //if Odd number, cannot have even divisors! 
            f = 3;

        while(f <= r)
        {
            if(n % f == 0)
                sum += f + (n /f);
            f++;
        }

        return sum;
    }

    

    public static int sumPdivisor(int n)
    {
        int sum = 1;

//        System.out.print(n + "= 1->");
        for(int f = 2; f < n; f++)
        {
            if(n % f == 0)
            {
//                System.out.print("->" + f);
                sum += f; 
            }
        }
//        System.out.println("");
        
        return sum;
    }
}
