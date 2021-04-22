package chapter1.section2;

import common.util.BinarySearchWithCount;
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/22 16:11
 **/
public class Ex9 {
    public static void main(String[] args) {
        Counter counter = new Counter("Total compare times");
        int key = 3;
        int[] a = {4, 6, 2, 7, 8, 3, 5, 1};
        BinarySearchWithCount.rank(key, a, counter);
        StdOut.println(counter);
    }
}
