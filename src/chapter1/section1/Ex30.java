package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/15 17:42
 **/
public class Ex30 {
    public static void main(String[] args) {
        boolean[][] a = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        for (boolean[] row : getCoPrime(a)) {
            for (boolean b : row) {
                StdOut.print(b + " ");
            }
            StdOut.println();
        }
    }

    private static boolean[][] getCoPrime(boolean[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = (Euclid.getGreatestCommonDivisor(i, j) == 1);
            }
        }
        return a;
    }
}
