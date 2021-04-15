package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/15 17:49
 **/
public class Euclid {

    public static int getGreatestCommonDivisor(int p, int q) {
        StdOut.printf("p=%d, q=%d%n", p ,q);
        if (p == 0 || q == 0) {
            return 1;
        }
        if (q > p) {
            int[] swapped = swap(p, q);
            p = swapped[0];
            q = swapped[1];
        }
        int remainder = p % q;
        if (remainder == 0) {
            return q;
        }
        if (remainder > 0) {
            return getGreatestCommonDivisor(q, p % q);
        }
        return 1;
    }

    private static int[] swap(int p, int q) {
        return new int[] {q, p};
    }
}
