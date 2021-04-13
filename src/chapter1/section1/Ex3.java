package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/13 14:51
 **/
public class Ex3 {
    public static void main(String[] args) {
        StdOut.println("Input first integer:");
        int firstInt = StdIn.readInt();
        StdOut.println("Input second integer:");
        int secondInt = StdIn.readInt();
        StdOut.println("Input third integer:");
        int thirdInt = StdIn.readInt();
        StdOut.println(firstInt == secondInt && secondInt == thirdInt ? "equal" : "not equal");
    }
}
