import java.math.BigInteger;
import java.math.BigDecimal;
import java.text.ParseException;

/**
 * Created by IntelliJ IDEA.
 * User: erez
 * Date: Jun 23, 2009
 * Time: 3:27:34 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * <p/>
 * A unit fraction contains 1 in the numerator.
 * The decimal representation of the unit fractions with denominators 2 to 10 are given:
 * <p/>
 * ^(1)/_(2)	= 	0.5
 * ^(1)/_(3)	= 	0.(3)
 * ^(1)/_(4)	= 	0.25
 * ^(1)/_(5)	= 	0.2
 * ^(1)/_(6)	= 	0.1(6)
 * ^(1)/_(7)	= 	0.(142857)
 * ^(1)/_(8)	= 	0.125
 * ^(1)/_(9)	= 	0.(1)
 * ^(1)/_(10)	= 	0.1
 * <p/>
 * Where 0.1(6) means 0.166666...,
 * and has a 1-digit recurring cycle. It can be seen that ^(1)/_(7) has a 6-digit recurring cycle.
 * <p/>
 * Find the value of d < 1000 for which ^(1)/_(d) contains the longest recurring cycle in its decimal fraction part.
 *
 * 1/7  = 0.1 ,
 */
public class Problem26 {

    public static void main(String[] args) throws ParseException
    {
        //in mathematica -:)
        //Table[Length[ RealDigits[1/i][[1]][[1]]], {i, 999}]
        //Select[m, # > 900 &] Print
        //{936, 940, 952, 970, 976, 982} answer is 1/983 has 982 digits
        
        BigDecimal n = new BigDecimal(1);
        for (int i = 2; i < 1000; i++)
        {
            BigDecimal l = n.divide(new BigDecimal(i), 2000, BigDecimal.ROUND_FLOOR);

            System.out.println("1/" + i + "=" + l);


        }



    }
}
