package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/14 17:06
 **/
public class Ex22 {
    public static void main(String[] args) {
        int key = 3;
        int[] a = {1, 1, 2, 3, 5, 7, 11, 13, 17};
        StdOut.println(BinarySearch.rank(key, a));
    }
}
