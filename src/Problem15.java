/**
 * Created by IntelliJ IDEA.
 * User: erez
 * Date: Jun 16, 2009
 * Time: 11:17:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem15 {

    /*
        Starting in the top left corner of a 2×2 grid,
        there are 6 routes (without backtracking) to the bottom right corner.\
        How many routes are there through a 20×20 grid?
     */


//         _ _ _ _
//        |_|_|_|_|
//        |_|_|_|_|
//        |_|_|_|_|
//        |_|_|_|_|


//         _ _ _ _ _ _ _ _ _ _
//        |_|_|_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|_|_|




    public static void main(String[] args)
    {
//                      n!
//        C(n,r) = -----------
//                   r!*(n-r)!

       /*
                            39!
            C(40,20) =  ----------
                        20! * 20!
        */

//        using mathematica..
        //40! / (20! * 20!) 
        //137846528820



    }



}
