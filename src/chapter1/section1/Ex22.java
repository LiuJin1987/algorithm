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

    static class BinarySearch {
        public static int rank(int key, int[] a) {
            return rank(key, a, 0, a.length - 1, 0);
        }

        public static int rank(int key, int[] a, int lo, int hi, int depth) {
            StringBuilder prefixStuff = new StringBuilder();
            for (int i = depth; i > 0; i--) {
                prefixStuff.append(" ");
            }
            StdOut.printf("%s%d %d%n", prefixStuff, lo, hi);
            //如果 key 存 在于 a[] 中， 它的 索引 不会 小于 lo 且不 会 大于 hi
            if (lo > hi) {
                return -1;
            }
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                return rank(key, a, lo, mid - 1, ++depth);
            } else if (key > a[mid]) {
                return rank(key, a, mid + 1, hi, ++depth);
            } else {
                return mid;
            }
        }
    }
}
