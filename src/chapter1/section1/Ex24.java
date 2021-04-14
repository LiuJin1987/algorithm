package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Map;
import java.util.Stack;

/**
 * @author liujinlc
 * @date 2021/4/14 17:24
 **/
public class Ex24 {
    public static void main(String[] args) {
        StdOut.println(Euclid.getGreatestCommonDivisor(105, 24));
        StdOut.println(Euclid.getGreatestCommonDivisor(111, 111));
        StdOut.println(Euclid.getGreatestCommonDivisor(234, 567));
    }

    static class Euclid {
        public static int getGreatestCommonDivisor(int p, int q) {
            StdOut.printf("p=%d, q=%d%n", p ,q);
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
}
