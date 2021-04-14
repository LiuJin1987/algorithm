package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/14 14:49
 **/
public class Ex20 {
    public static void main(String[] args) {
        StdOut.println(lnFactorialN(0));
        StdOut.println(lnFactorialN(1));
        StdOut.println(lnFactorialN(2));
        StdOut.println(lnFactorialN(1024));
    }

    /**
     * f = ln(N!)
     *
     * factorial:
     * N! = N * (N - 1) * (N - 2) * ... * 2 * 1
     * 0! = 1
     *
     * rule of logarithmic operations:
     * ln(M * N) = lnM + lnN
     *
     * formula of change of base of logarithms:
     * lnX = lgX / lgE (E is Math.E = 2.7182818284590452354)
     *
     * ln(N!) = lnN + ln(N - 1) + ... + ln2 + ln1
     *        = lgN / lgE + lg(N - 1) / lgE + ... + lg2 / lgE + lg1 / lgE
     *        = lgN / lgE + ln((N - 1)!)
     *
     * @param N     number to factorise and ln
     * @return      a number factorised and lned from N
     */
    private static double lnFactorialN(int N) {
        if (N < 0) {
            return 0.0;
        }
        if (N == 0) {
            return 0.0;
        }
        if (N == 1) {
            return 0.0;
        }
        return Math.log(N) / Math.log(Math.E) + lnFactorialN(N - 1);
    }
}
