package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/15 8:57
 **/
public class Ex26 {
    public static void main(String[] args) {
        for (int i : sortThreeNum(5, 4, 3)) {
            StdOut.println(i);
        }
    }

    private static int[] sortThreeNum(int a, int b, int c) {
        int t;
        // => a < b
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        // => a < c
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        // => b < c
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        // => a < b < c
        return new int[] {a, b, c};
    }
}
