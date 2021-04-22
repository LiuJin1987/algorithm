package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/22 15:59
 **/
public class Ex7 {
    public static void main(String[] args) {
        StdOut.println(mystery("1234567890"));
    }

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) {
            return s;
        }
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(a) + mystery(b);
    }
}
