/**

 If we list all the natural numbers below 10 that are multiples of 3 or 5,
 we get 3, 5, 6 and 9. The sum of these multiples is 23.
  Find the sum of all the multiples of 3 or 5 below 1000.

 */
public class Problem1 {

    public static void main(String[] args) {
        int mulSum = 8;

        for (int i = 6; i < 1000; i++) {
              if( i % 3  == 0 ){
                 mulSum += i;
                  System.out.println("Mul of 3 =" + i);
              }
              else if ( i % 5  == 0 ){
                 mulSum += i;
                  System.out.println("Mul of 5 =" + i);
              }
        }

        System.out.println("Multiplers sum is =" + mulSum);
    }
}
