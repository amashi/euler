import java.util.*;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p/>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {

    public static void main(String[] args) {

        Vector palindromes = new Vector();
        int digit1 = 999; //product 1
        int digit2 = 999;

        TreeSet<Integer> pa = new TreeSet<Integer>();

        for (int x = 0; x < 999; x++) {
            for (int i = 0; i < 999; i++) {
                int digit = digit1 * digit2;

                if(digit == 906609)
                {
                    System.out.println("products " + digit1 + " x " + digit2);   
                }

                digit1--;
                if (isPalindrome(digit)) {
                    pa.add(digit);
                }

            }
            digit2--;
            digit1 = 999; 
        }

        Object array[] = palindromes.toArray();
        Arrays.sort(array);

        for (Iterator<Integer> integerIterator = pa.iterator(); integerIterator.hasNext();) {
            Integer palin = integerIterator.next();
            System.out.println("palin = " + palin);
        }

        System.out.println("the highest palindrom is=" + pa.last());

//        for(int i = 0; i < 1000; i++){
//            int digit = digit1 * digit2;
//            System.out.println("digit = " + digit);
//
//            if(isPalindrome(digit)){
//                System.out.println("found palindrom = " + digit);
//                System.out.println(digit1 + " x " + digit2);
//                break;
//            }
//            else
//            {
//                digit1--;
//                digit = digit1 * digit2;
//                System.out.println("digit = " + digit);
//                if(isPalindrome(digit)){
//                    System.out.println("found palindrom = " + digit);
//                    System.out.println(digit1 + " x " + digit2);
//                   break;
//                }
//            }
//
//
//            digit2--;
//        }
    }

    public static boolean isPalindrome(int num) {
        String testNum = Integer.toString(num);

        char[] array = testNum.toCharArray();
        char[] array2 = new char[array.length];

        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            array2[array.length - i - 1] = c;
        }
//        System.out.println("array = " + testNum);
//        System.out.println("array2 = " + String.valueOf(array2));
        return testNum.equals(new String(array2));
    }
}
