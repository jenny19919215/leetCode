package hsbc;// Java Program for above approach

import java.util.HashSet;
import java.util.Set;

class Pair {
    int x;
    int y;

    // Constructor
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MinLinesToCoverPoints {

    //  Utility method to get gcd of a and b
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // method returns reduced form of dy/dx as a pair
    public static Pair getReducedForm(int dy, int dx) {
        int g = gcd(Math.abs(dy), Math.abs(dx));

        //    get sign of result
        boolean sign = (dy < 0) ^ (dx < 0);
        Pair res = new Pair(0, 0);

        if (sign) {
            res.x = -Math.abs(dy) / g;
            res.y = Math.abs(dx) / g;
        } else {
            res.x = Math.abs(dy) / g;
            res.y = Math.abs(dx) / g;
        }
        return res;
    }

    /*  method returns minimum number of lines to
    cover all points where all lines goes
    through (xO, yO) */

    public static int minLinesToCoverPoints(int points[][],
                                            int N, int xO,
                                            int yO) {
        // set to store slope as a string
        Set<String> st = new HashSet<String>();

        Pair temp;
        int minLines = 0;

        //    loop over all points once
        for (int i = 0; i < N; i++) {
            //    get x and y co-ordinate of current point
            int curX = points[i][0];
            int curY = points[i][1];

            temp = getReducedForm(curY - yO, curX - xO);

            // convert pair into string to store in set
            String tempString = temp.x + "," + temp.y;

            // if this slope is not there in set,
            // increase ans by 1 and insert in set

            if (st.contains(tempString) == false) {
                st.add(tempString);
                minLines += 1;
            }
        }

        return minLines;
    }

    // Driver code
    public static void main(String[] args) {
        int xO, yO;
        xO = 1;
        yO = 0;

        int points[][] = {{-1, 3},
                {4, 3},
                {2, 1},
                {-1, -2},
                {3, -3}};

        int N = points.length;
        System.out.println(
                minLinesToCoverPoints(points, N, xO, yO));
    }


// This code is contributed by rj13to.
}
