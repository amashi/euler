import java.math.BigInteger;
import java.io.*;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: erez
 * Date: Jun 18, 2009
 * Time: 2:05:52 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.
 * <p/>
 * 3
 * 7 5
 * 2 4 6
 * 8 5 9 3
 * <p/>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p/>
 * Find the maximum total from top to bottom of the triangle below:
 * <p/>
 * 75
 * 95 64
 * 17 47 82
 * 18 35 87 10
 * 20 04 82 47 65
 * 19 01 23 75 03 34
 * 88 02 77 73 07 63 67
 * 99 65 04 28 06 16 70 92
 * 41 41 26 56 83 40 80 70 33
 * 41 48 72 33 47 32 37 16 94 29
 * 53 71 44 65 25 43 91 52 97 51 14
 * 70 11 33 28 77 73 17 78 39 68 17 57
 * 91 71 52 38 17 14 91 43 58 50 27 29 48
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * <p/>
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 */
public class Problem17 {

    static int steps = 0;
    static int sum = 0;

    public static void main(String[] args) throws InterruptedException, IOException
    {
           /*
        String triangle =
                "75\n" +
                        "95 64\n" +
                        "17 47 82\n" +
                        "18 35 87 10\n" +
                        "20 04 82 47 65\n" +
                        "19 01 23 75 03 34\n" +
                        "88 02 77 73 07 63 67\n" +
                        "99 65 04 28 06 16 70 92\n" +
                        "41 41 26 56 83 40 80 70 33\n" +
                        "41 48 72 33 47 32 37 16 94 29\n" +
                        "53 71 44 65 25 43 91 52 97 51 14\n" +
                        "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                        "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                        "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                        "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

        String[] tArray = triangle.split("\n");
        int[][] grid = new int[tArray.length][];
        int rI = 0;
        for (String row : tArray)
        {
            String[] elements = row.split(" ");
            grid[rI] = new int[elements.length];
            int eI = 0;
            for (String element : elements)
            {
                grid[rI][eI] = Integer.valueOf(element);
                eI++;
            }
            rI++;
        }


        int h = highRoute(grid);
        System.out.println("h = " + h + " steps=" + steps);
          */
        Problem67();

    }

    public static void Problem67() throws IOException
    {
        FileReader fr = new FileReader("C:\\Projects\\Euler_projects\\triangle.txt");
        BufferedReader bis = new BufferedReader(fr);
        String line;
        Vector<String> lines = new Vector<String>();
        while((line = bis.readLine()) != null)
            lines.add(line);

        int[][] grid = new int[lines.size()][];
        int rI = 0;
        for (String row : lines)
        {
            String[] elements = row.split(" ");
            grid[rI] = new int[elements.length];
            int eI = 0;
            for (String element : elements)
            {
                grid[rI][eI] = Integer.valueOf(element);
                eI++;
            }
            rI++;
        }

//        for (int[] ints : grid)
//        {
//            for (int anInt : ints)
//            {
//                System.out.print(anInt + " ");
//            }
//            System.out.println("");
//        }


        int h = highRoute(grid);
        System.out.println("h = " + h + " steps=" + steps);

    }
   

    public static int checkRouteSum(int[][] grid, int r, int x)
    {
        int rSum = grid[r][x];

        while (r < grid.length - 1)
        {
            int e1 = grid[r + 1][x];
            int e2 = grid[r + 1][x + 1];
            if (e1 > e2)
            {
                rSum += e1;
            }
            else
            {
                rSum += e2;
                x++;
            }
            r++;
            steps++;
        }
        return rSum;
    }

    public static int checkRouteSum2(int[][] grid, int r, int x)
    {
        int rSum = grid[r][x];

        while (r < grid.length - 1)
        {
            int e1 = grid[r + 1][x];
            int e2 = grid[r + 1][x + 1];
            if (checkRouteSum2(grid, r + 1, x) > checkRouteSum2(grid, r + 1, x + 1))
            {
                rSum += e1;
            }
            else
            {
                rSum += e2;
                x++;
            }
            r++;
            steps++;
        }
        return rSum;
    }

    public static int highRoute(int[][] grid)
    {
        int r = 0;
        int x = 0;
        int sum = grid[r][x]; //start with top

        while (r < grid.length - 1)
        {
            if (checkRouteSum(grid, r + 1, x) > checkRouteSum(grid, r + 1, x + 1))
            {
                sum += grid[r + 1][x];
//                System.out.println(grid[r + 1][x]);
            }
            else
            {
                sum += grid[r + 1][x + 1];
//                System.out.println(grid[r + 1][x+1]);
                x++;
            }
            r++;
            steps++;
        }
        return sum;
    }


   


        /*
           /Find the sum of the digits in the number 100!
           BigInteger bi = new BigInteger("1");
           for(int i = 2; i<100; i++)
           {
               bi = bi.multiply(new BigInteger(Integer.toString(i)));
           }
           char [] digits = bi.toString().toCharArray();
           int nSum = 0;
           for(char digit: digits)
           {
               nSum += Character.getNumericValue(digit);
           }
           System.out.println("sum=" + nSum);

        */
    }
