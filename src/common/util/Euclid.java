package common.util;

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
            int tmp = p;
            p = q;
            q = tmp;
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

    public static long getGreatestCommonDivisor(long p, long q) {
        if (p == 0 || q == 0) {
            return 1;
        }
        if (q > p) {
            long tmp = p;
            p = q;
            q = tmp;
        }
        long remainder = p % q;
        if (remainder == 0) {
            return q;
        }
        if (remainder > 0) {
            return getGreatestCommonDivisor(q, p % q);
        }
        return 1L;
    }
}
