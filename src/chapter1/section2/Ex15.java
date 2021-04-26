package chapter1.section2;

import edu.princeton.cs.algs4.In;

/**
 * @author liujinlc
 * @date 2021/4/25 11:35
 **/
public class Ex15 {

    public static void main(String[] args) {

    }

    public static int[] readInts(String name) {
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ints[i] = Integer.parseInt(words[i]);
        }
        return ints;
    }
}
