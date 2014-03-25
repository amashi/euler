import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by IntelliJ IDEA.
 * User: erez
 * Date: Jun 18, 2009
 * Time: 11:58:01 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * You are given the following information,
 * but you may prefer to do some research for yourself.
 * <p/>
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4,
 * but not on a century unless it is divisible by 400.
 * <p/>
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem18 {
    public static void main(String[] args)
    {
                
        int[] mS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //find Num of Sun - between 1 Jan 1901 -> 31 Dec 2000
        int sundays = 0;
        int sC =8; //stars looping 1900 1 Jan is Monday -
        for (int y = 1900; y <= 2000; y++)
        {
            if (isLeapYear(y))
            {
                mS[1] = 29;
                System.out.println(y + "=Leap Year");
            }
            else
                mS[1] = 28;

            for (int m = 1; m <= 12; m++)
            {
                for (int d = 1; d <= mS[m - 1]; d++)
                {
                    //System.out.println(d + "/" + m + "/" + y);
                    if(sC % 7 == 0 && y >= 1901 && d ==1)
                    {
                        System.out.println("Sunday  -> " + d + "/" + m + "/" + y);
                        sundays++; 
                    }
                    sC++;
                }
            }
        }
        System.out.println("sundays = " + sundays);
    }

    public static boolean isLeapYear(int y)
    {
        if (y % 400 == 0)
            return true;
        else if (y % 100 == 0)
            return false;
        else if (y % 4 == 0)
            return true;

        return false;
    }
}
