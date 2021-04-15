package chapter1.section1;

import java.util.List;

/**
 * @author liujinlc
 * @date 2021/4/15 16:36
 **/
public class BinarySearch {
    public static int rank(int key, List<Integer> a) {
        return rank(key, a, 0, a.size() - 1);
    }

    public static int rank(int key, List<Integer> a, int lo, int hi) {
        //如果 key 存 在于 a[] 中， 它的 索引 不会 小于 lo 且不 会 大于 hi
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a.get(mid)) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a.get(mid)) {
            return rank(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        //如果 key 存 在于 a[] 中， 它的 索引 不会 小于 lo 且不 会 大于 hi
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }
}
