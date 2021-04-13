package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/13 17:09
 **/
public class Ex11 {
    public static void main(String[] args) {
        boolean[][] booleanMatrix = {{true, true, false}, {true , false, false}, {false, true, true}};
        printBooleanMatrix(booleanMatrix);
    }

    private static void printBooleanMatrix(boolean[][] booleans) {
        for (boolean[] aBoolean : booleans) {
            for (boolean b : aBoolean) {
                StdOut.print(b ? "*" : " ");
            }
            StdOut.println();
        }
    }
}
