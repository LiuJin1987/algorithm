package chapter1.section1;

import common.util.Euclid;
import edu.princeton.cs.algs4.StdOut;

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
}
