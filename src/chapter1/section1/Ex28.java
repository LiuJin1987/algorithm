package chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author liujinlc
 * @date 2021/4/15 10:59
 **/
public class Ex28 {
    public static void main(String[] args) {
        StdOut.print("Input white list filter:");
        String filter = StdIn.readString();
        StdOut.print("Input white list filepath:");
        // resource/testfiles/chapter1/section1/Ex23.txt
        String path = StdIn.readString();
        //removeRepeat();
    }

    private static void removeRepeat(String whiteListFile, String filter) {
        In in = new In(whiteListFile);
        int[] whiteList = in.readAllInts();
        Arrays.sort(whiteList);
        StdOut.print("Input a number to check:");
        String inputString;
        while (!"exit".equals(inputString = StdIn.readString())) {
            int key = Integer.parseInt(inputString);
            if ("+".equals(filter) && Ex22.BinarySearch.rank(key, whiteList) == -1) {
                StdOut.println(key);
            } else if ("-".equals(filter) && Ex22.BinarySearch.rank(key, whiteList) != -1) {
                StdOut.println(key);
            }
            StdOut.print("Input another number to check, input exit to exit:");
        }
    }
}
