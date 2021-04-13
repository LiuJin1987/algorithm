package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/13 16:15
 **/
public class Ex9 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        StdOut.println("Input a positive decimal: ");
        int n = StdIn.readInt();
        String binaryString = "";
        for (; n > 0; n /= 2) {
            binaryString = (n % 2) + binaryString;
        }
        StdOut.println(binaryString);
    }
}
