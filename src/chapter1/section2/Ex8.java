package chapter1.section2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/22 16:02
 **/
public class Ex8 {
    public static void main(String[] args) {
        int[] a = new In("resource/testfiles/algs4-data/largeG.txt").readAllInts();
        int[] b = new In("resource/testfiles/algs4-data/largeT.txt").readAllInts();
        StdOut.println(a[0]);
        StdOut.println(b[0]);
        long swapBegin = System.currentTimeMillis();
        int[] tmp = a;
        a = b;
        b = tmp;
        long swapEnd = System.currentTimeMillis();
        StdOut.printf("Swap costs %d ms.%n", (swapEnd - swapBegin));
        StdOut.println(a[0]);
        StdOut.println(b[0]);
    }
}
