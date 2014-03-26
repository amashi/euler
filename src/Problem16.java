import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: erez
 * Date: Jun 17, 2009
 * Time: 6:15:46 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * 2^(15) = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * <p/>
 * What is the sum of the digits of the number 2^(1000)?
 */
public class Problem16 {

    public static void main(String[] args)
    {
        Problem17();
    }

    /*
        If the numbers 1 to 5 are written out in words:
        one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

        If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
        how many letters would be used?

        NOTE: Do not count spaces or hyphens. For example,
        342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
         The use of "and" when writing out numbers is in compliance with British usage.
     */
    public static void Problem17()
    {
        /*
        String thousand = "thousand";
        String hundred = "hundred";
        String[] single = {
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen"
        };
        String[] tens = {
                "twenty",
                "thirty",
                "forty",
                "fifty",
                "sixty",
                "seventy",
                "eighty",
                "ninety"
        };

  */

        int sum = 0;

        for (double i = 1; i < 1000; i++)
        {
            int cNum = 0;

            if (i / 100 >= 1)
            {
                int x = (int) (i / 100) * 100;

                cNum += getVal(x/100);
                cNum += getVal(100);

                int nx = (int)i - x;

                if(nx != 0) //for x00 no need for and
                    cNum += 3; //and

                if(nx <= 10 )
                    cNum+= getVal(nx);
                else if (nx > 10 && nx < 20)
                {
                    cNum+= getVal(nx);
                    System.out.print("i=" + i + " x=" + x + " nx=" + nx + "\t");
                }
                else //21 - 99
                {
                    int x22 = (int)((double) nx /10)*10;
                    cNum+= getVal(x22);
                    cNum+= getVal(nx -x22);
                    System.out.print("i=" + i + " x=" + x + " nx=" + nx + " x22=" + x22 + "\t");
                }
            }
            else if (i / 10 > 1)
            {
                if ((int) i > 10 && (int) i < 20)
                {
                    cNum+= getVal((int)i);
                }
                else
                {
                    int x = (int) (i / 10) * 10;
                    int x2 = (int) i - x;
                    cNum += getVal(x);
                    cNum += getVal(x2);
                }
            }
            else
            {
                cNum += getVal((int) i);
            }
            sum+=cNum;
            System.out.println("For number=" + (int)i + " Number of letters=" + cNum);
        }
        //add 1000... :)
        sum += getVal(1000) + getVal(1); 
        System.out.println("Total Sum of letters = " + sum );
    }

    
    // 1,2,6,10         = 3
    // 4,5,9            = 4
    // 3,7,8,40,50,60   = 5
    // 11,12,20,30,80,90= 6
    // 15,16,70,100     = 7
    // 13,14,18,19,1000 = 8
    // 17               = 9
    public static int getVal(int n)
    {
        int val = 0;
        switch (n)
        {
            case 1:
            case 2:
            case 6:
            case 10:
                val = 3;
                break;
            case 4:
            case 5:
            case 9:
                val = 4;
                break;

            case 3:
            case 7:
            case 8:
            case 40:
            case 50:
            case 60:
                val = 5;
                break;
            case 11:
            case 12:
            case 20:
            case 30:
            case 80:
            case 90:
                val = 6;
                break;
            case 15:
            case 16:
            case 70:
            case 100:
                val = 7;
                break;
            case 13:
            case 14:
            case 18:
            case 19:
            case 1000:
                val = 8;
                break;
            case 17:
                val = 9;
                break;
        }
        return val;
    }


    public static void Problem16()
    {
        BigInteger n = new BigInteger("2");
        n = n.pow(1000);
        System.out.println(n);

        char[] list = n.toString().toCharArray();
        int sum = 0;
        for (char num : list)
        {
            sum += Character.getNumericValue(num);
        }

        System.out.println("sum=" + sum);

    }
}
