package common.util;

import edu.princeton.cs.algs4.Counter;

import java.util.List;

/**
 * @author liujinlc
 * @date 2021/4/15 16:36
 **/
public class BinarySearchWithCount {
    public static int rank(int key, List<Integer> a, Counter counter) {
        return rank(key, a, 0, a.size() - 1, counter);
    }

    public static int rank(int key, List<Integer> a, int lo, int hi, Counter counter) {
        //如果 key 存 在于 a[] 中， 它的 索引 不会 小于 lo 且不 会 大于 hi
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        counter.increment();
        if (key < a.get(mid)) {
            return rank(key, a, lo, mid - 1, counter);
        } else if (key > a.get(mid)) {
            return rank(key, a, mid + 1, hi, counter);
        } else {
            return mid;
        }
    }

    public static int rank(int key, int[] a, Counter counter) {
        return rank(key, a, 0, a.length - 1, counter);
    }

    public static int rank(int key, int[] a, int lo, int hi, Counter counter) {
        //如果 key 存 在于 a[] 中， 它的 索引 不会 小于 lo 且不 会 大于 hi
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        counter.increment();
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1, counter);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi, counter);
        } else {
            return mid;
        }
    }
}
