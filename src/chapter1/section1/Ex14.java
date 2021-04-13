package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Ex14 {
    public static void main(String[] args) {
        StdOut.println(lg(1));
        StdOut.println(lg(3));
        StdOut.println(lg(5));
        StdOut.println(lg(7));
        StdOut.println(lg(9));
        StdOut.println(lg(1023));
        StdOut.println(lg(1025));
    }

    private static int lg(int antilogarithm) {
        return Ex9.getBinaryString(antilogarithm).length() - 1;
    }
}
