package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.math.BigDecimal;

/**
 * @author liujinlc
 * @date 2021/4/15 9:04
 **/
public class Ex27 {

    /*
     will overflow because Long.MAX_VALUE = 0x7fffffffffffffffL = 2 ^ 63 - 1 < 2 ^ 100
     */
    private static long COUNT = 0;
    /*
    N = 0   K = 0   COUNT2 = 1
    N = 1   K = 0   COUNT2 = 3
    N = 1   K = 1   COUNT2 = 5
    N = 2   K = 0   COUNT2 = 5
    N = 2   K = 1   COUNT2 = 9
    N = 2   K = 2   COUNT2 = 11
    N = 3   K = 0   COUNT2 = 7
    N = 3   K = 1   COUNT2 = 13
    N = 3   K = 2   COUNT2 = 17
    N = 3   K = 3   COUNT2 = 19
    COUNT2 = A * N + B * K + C
    A =
    B =
    C = 1
    7751
     */
    private static long COUNT2 = 0;
    private static double[][] MATRIX;

    public static void main(String[] args) {
        /*
         * N = 1, recursion times = 2
         * N = 2, recursion times = 4
         * N = n, recursion times = 2 ^ n
         * N = 100, recursion times = 2 ^ 100 = 1024 ^ 10 > 1,000,000,000,000,000,000,000,000,000,000
         */
        /*StdOut.println("binomial=" + binomial(100, 50, 0.25) + " COUNT=" + COUNT);*/
        StdOut.println("betterBinomial=" + betterBinomial(3, 3, 0.25) + " COUNT2=" + COUNT2);
        /*StdOut.println("betterBinomial=" + betterBinomial(100, 50, 0.25) + " COUNT2=" + COUNT2);*/
        /*StdOut.println(myBinomial(1, 1, 0.25));
        StdOut.println(myBinomial(2, 1, 0.25));
        StdOut.println(myBinomial(10, 2, 0.25));
        StdOut.println(myBinomial(100, 50, 0.25));*/
    }

    /**
     * probability of binomial distribution
     *
     * @param N     times of all trial
     * @param k     ordinal of trial
     * @param p     the probability of issue's occurrence in one time random standalone trial
     * @return      the probability of issue's occurrence in N times random standalone trial
     */
    public static double binomial(int N, int k, double p) {
        COUNT++;
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k, p);
    }

    /**
     * use a matrix to expand and store binomial items
     *
     * MATRIX[0][0] N * MATRIX[0][1] 1/2 * N * (N -1 ) * MATRIX[0][2]   ... MATRIX[0][k]
     * ...
     * 0    0   0   0   0   1   3                   3                       1
     * 0    0   0   0   0   0   MATRIX[N-2][k-1]    2 * MATRIX[N-2][k-1]    MATRIX[N-2][k]
     * 0    0   0   0   0   0   0                   MATRIX[N-1][k-1]        MATRIX[N-1][k]
     * 0    0   0   0   0   0   0                   0                       MATRIX[N][k]
     *
     * @param N     times of all trial
     * @param k     ordinal of trial
     * @param p     the probability of issue's occurrence in one time random standalone trial
     * @return      the probability of issue's occurrence in N times random standalone trial
     */
    private static double bin(int N, int k, double p) {
        COUNT2++;
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        if (MATRIX[N][k] == -1) {
            MATRIX[N][k] = (1.0 - p) * bin(N - 1, k, p) + p * bin(N - 1, k - 1, p);
        }
        return MATRIX[N][k];
    }

    /**
     * probability of binomial distribution
     *
     * @param N     times of all trial
     * @param k     ordinal of trial
     * @param p     the probability of issue's occurrence in one time random standalone trial
     * @return      the probability of issue's occurrence in N times random standalone trial
     */
    public static double betterBinomial(int N, int k, double p) {
        MATRIX = new double[N + 1][k + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                MATRIX[i][j] = -1;
            }
        }
        return bin(N, k, p);
    }

    /**
     * probability of binomial distribution
     *
     * P{X = k} = C * (p ^ k) * ((1 - p) ^ (N - k)), while C = N! / k! / (N - k)!
     *
     * @param N     times of all trial
     * @param k     ordinal of trial
     * @param p     the probability of issue's occurrence in one time random standalone trial
     * @return      the probability of issue's occurrence in N times random standalone trial
     */
    public static BigDecimal myBinomial(int N, int k, double p) {
        BigDecimal P = new BigDecimal(p);
        BigDecimal p_1P = new BigDecimal(1 - p);
        BigDecimal C = factorial(N)
                .divide(factorial(k), BigDecimal.ROUND_HALF_UP)
                .divide(factorial(N - k), BigDecimal.ROUND_HALF_UP);
        return C.multiply(P.pow(k)).multiply(p_1P.pow(N - k));
    }

    private static BigDecimal factorial(int N) {
        if (N == 0) {
            return new BigDecimal("1");
        }
        return new BigDecimal(N).multiply(factorial(N - 1));
    }
}
