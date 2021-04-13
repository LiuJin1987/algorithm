package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/13 15:13
 **/
public class Ex5 {
    public static void main(String[] args) {
        StdOut.println("Input double value of x:");
        double x = StdIn.readDouble();
        StdOut.println("Input double value of y:");
        double y = StdIn.readDouble();
        StdOut.println(x < 1.0 && x > 0.0 && y < 1.0 && y > 0.0);
    }
}
