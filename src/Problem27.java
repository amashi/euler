/**
 * Created by IntelliJ IDEA.
 * User: erez
 * Date: Jun 25, 2009
 * Time: 6:01:34 PM
 * To change this template use File | Settings | File Templates.
 *



Euler published the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39.
 However, when n = 40, 40^(2) + 40 + 41 = 40(40 + 1) + 41 is divisible by 41,
 and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

Using computers, the incredible formula  n² ? 79n + 1601 was discovered, which produces 80 primes
 for the consecutive 
 values n = 0 to 79. The product of the coefficients, ?79 and 1601, is ?126479.

Considering quadratics of the form:

    n² + an + b, where |a| < 1000 and |b| < 1000

    where |n| is the modulus/absolute value of n
    e.g. |11| = 11 and |?4| = 4

Find the product of the coefficients, a and b,
 for the quadratic expression that produces the maximum number of primes for consecutive values of n,
 starting with n = 0.

 */

//http://1ke6r8hym0s990gqy2g2.vaxman.s3.amazonaws.com/WebIntegrator_Quick_Start_Guide.pdf?AWSAccessKeyId=1KE6R8HYM0S990GQY2G2&Expires=1246278463&Signature=MHaSGcgdEtekDut29GH0MoEYPUg%3D
public class Problem27 {

    public static void main(String[] args)
    {
        for(int i = 0; i <= 79; i++)
        {
            int n = i*i - (i*79) + 1601;
            if(isPrime(n))
                System.out.println("i=" + i + " prime="+n);
        }

        
    }

    public static boolean isPrime(long n)
    {
        return sumDivisors(n) == n+1; //divide by 1 and itself
    }

    public static int sumDivisors(long n)
    {
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
}
