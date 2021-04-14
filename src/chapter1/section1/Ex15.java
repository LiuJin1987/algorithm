package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/14 9:04
 **/
public class Ex15 {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        for (int num : histogram(a, 3)) {
            StdOut.print(num + " ");
        }
    }

    private static int[] histogram(int[] a, int M) {
        int[] timesArray = new int[M];
        for (int i = 0; i < M; i++) {
            for (int num : a) {
                if (num == i) {
                    timesArray[i]++;
                }
            }
        }
        return timesArray;
    }
}
