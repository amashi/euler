import java.math.BigInteger;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 1^(2) + 2^(2) + ... + 10^(2) = 385
 * <p/>
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^(2) = 55^(2) = 3025
 * <p/>
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 ? 385 = 2640.
 * <p/>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem6 {

    public static void main(String[] args)
    {

//        int limit = 100;
//        long sumSquares = 0;
//        long squaresSum = 0;
//
//        for(int i = 0; i < limit; i++){
//            sumSquares += (i+1) * (i+1);
//            squaresSum += (i+1);
//        }
//
//        squaresSum *= squaresSum;
//
//
//        System.out.println("squaresSum = " + squaresSum);
//        System.out.println("sumSquares = " + sumSquares);
//
//        System.out.println("difference =" + (squaresSum - sumSquares));


//        Find the greatest product of five consecutive digits in the 1000-digit theNumber.

        BigInteger num = new BigInteger(
                "73167176531330624919225119674426574742355349194934" +
                        "96983520312774506326239578318016984801869478851843" +
                        "85861560789112949495459501737958331952853208805511" +
                        "12540698747158523863050715693290963295227443043557" +
                        "66896648950445244523161731856403098711121722383113" +
                        "62229893423380308135336276614282806444486645238749" +
                        "30358907296290491560440772390713810515859307960866" +
                        "70172427121883998797908792274921901699720888093776" +
                        "65727333001053367881220235421809751254540594752243" +
                        "52584907711670556013604839586446706324415722155397" +
                        "53697817977846174064955149290862569321978468622482" +
                        "83972241375657056057490261407972968652414535100474" +
                        "82166370484403199890008895243450658541227588666881" +
                        "16427171479924442928230863465674813919123162824586" +
                        "17866458359124566529476545682848912883142607690042" +
                        "24219022671055626321111109370544217506941658960408" +
                        "07198403850962455444362981230987879927244284909188" +
                        "84580156166097919133875499200524063689912560717606" +
                        "05886116467109405077541002256983155200055935729725" +
                        "71636269561882670428252483600823257530420752963450");


        BigInteger res[] = num.divideAndRemainder(new BigInteger("2"));

        for (int i = 0; i < res.length; i++)
        {
            BigInteger re = res[i];
//            System.out.println("re = " + re);
        }


        String theNumber = "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";


        char scan[] = theNumber.toCharArray();
        TreeSet<Integer> numbers = new TreeSet<Integer>();

        for (int t = 0; t < 10; t++)
        {
            numbers.clear();
            for (int i = 0; i < scan.length; i++)
            {
                char c = scan[i];

                if (Character.getNumericValue(c) == t && i + 5 <= scan.length)
                {
                    numbers.add(productOf(scan, i));
                }
            }

            int big = 1;
            for (Iterator<Integer> integerIterator = numbers.iterator(); integerIterator.hasNext();)
            {
                Integer x = integerIterator.next();

                char cnVal[] = x.toString().toCharArray();

                int test = Character.getNumericValue(cnVal[0]);

                for (int i = 1; i < cnVal.length; i++)
                {
                    test *= Character.getNumericValue(cnVal[i]);
                }
                if (test > big)
                    big = test;
            }

            System.out.println("the big for first digit " + t + " theNumber=" + big);
        }


        //the winning alg.. :) 
        char z[] = theNumber.toCharArray();
        int u = 1;

        for (int i = 0; i < z.length; i++)
        {
            if (i + 5 <= z.length)
            {
                int p = Character.getNumericValue(z[i]);

                for (int x = 1; x < 5; x++)
                    p *= Character.getNumericValue(z[i+x]);

                if(p > u)
                    u = p;
            }
        }

        System.out.println("u = " + u);
        //other approach...


    }

    public static int productOf(char number[], int index)
    {
        String x = new String(number);

        String y = x.substring(index, index + 5);

        return Integer.valueOf(y);
    }


}
