package common.util;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/20 10:08
 **/
public class ArrayPrinter {

    public static void print(int[] array) {
        for (int element : array) {
            StdOut.printf("%d ", element);
        }
        StdOut.println();
    }

    public static void print(int[][] array) {
        for (int[] row : array) {
            for (int times : row) {
                StdOut.printf("%d ", times);
            }
            StdOut.println();
        }
    }
}
