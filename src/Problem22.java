import java.util.*;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: erez
 * Date: Jun 19, 2009
 * Time: 5:11:07 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * Using names.txt (right click and 'Save Link/Target As...'),
 * a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * <p/>
 * Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * <p/>
 * For example, when the list is sorted into alphabetical order,
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 * <p/>
 * What is the total of all the name scores in the file?
 * <p/>
 * <p/>
 * a b c d e f g h i j k l m n o p q r s t u v w x y z
 */
public class Problem22 {
    static String alpha = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //0 TO MAKE INDEX START WITH 1 :))


    public static void main(String[] args) throws IOException
    {
        long sum = 0;
        File f = new File("C:\\Projects\\Euler_projects\\names.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String file = br.readLine();

        String[] names = file.replaceAll("\"", "").split(",");
        Arrays.sort(names);

        int pos = 1;
        for (String name : names)
        {
            int ns = getNameScore(name, pos);
            sum += ns;
            pos++;
        }

        System.out.println("sum = " + sum);
    }

    public static int getNameScore(String name, int pos)
    {
        int sum = 0;

        char[] letters = name.toCharArray();

        for (char letter : letters)
        {
            sum += alpha.indexOf(letter);
        }

        System.out.println(name + " letters sum=" + sum + " x pos=" + pos + " ->" + sum * pos);

        return sum * pos;
    }
}
