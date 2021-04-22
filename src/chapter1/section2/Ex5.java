package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Locale;

/**
 * @author liujinlc
 * @date 2021/4/22 15:38
 **/
public class Ex5 {

    public static void main(String[] args) {
        String s = "Hello World";
        String toUpperCased = s.toUpperCase();
        String subStringed = s.substring(6, 11);
        // Hello World
        StdOut.println(s);
        // HELLO WORLD
        StdOut.println(toUpperCased);
        // World
        StdOut.println(subStringed);
    }
}
