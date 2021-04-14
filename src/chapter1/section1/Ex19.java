package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.math.BigInteger;

/**
 * @author liujinlc
 * @date 2021/4/14 9:40
 **/
public class Ex19 {
    public static void main(String[] args) {
        /*
        for (int N = 0; N < 100; N++) {
            //N = 49, F(N) = 7778742049 in an hour
            StdOut.println(N + " " + F(N));
        }
        */
        for (int N = 0; N < 100; N++) {
            StdOut.println(N + " " + Fibonacci.betterF(N));
        }
    }

    static class Fibonacci {
        public static long F(int N) {
            if (N == 0) {
                return 0;
            }
            if (N == 1) {
                return 1;
            }
            return F(N - 1) + F(N - 2);
        }

        public static String betterF(int N) {
            if (N == 0) {
                return "0";
            }
            // use BigInteger to handle arithmetic overflow
            BigInteger p = new BigInteger("0");
            BigInteger q = new BigInteger("1");
            for (int i = 1; i <= N; i++) {
                p = p.add(q);
                q = p.subtract(q);
            }
            return p.toString();
        }
    }
}
