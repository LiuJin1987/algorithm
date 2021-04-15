package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author liujinlc
 * @date 2021/4/15 16:32
 **/
public class Ex29 {
    public static void main(String[] args) {
        int[] a = {14, 51, 36, 45, 46, 75, 42, 34, 52, 34, 23, 22, 56, 24, 53, 45, 23, 45};
        Arrays.sort(a);
        for (int i : a) {
            StdOut.printf("%d ", i);
        }
        StdOut.println();
        StdOut.println(BinarySearch.rank(45, a));
        StdOut.println(BinarySearch.count(45, a));
    }

    static class BinarySearch{
        private static int rank(int key, int[] a) {
            int low = 0;
            int high = a.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (a[mid] == key) {
                    while (mid >= 0 && a[mid] == key){
                        mid--;
                    }
                    return ++mid;
                } else if (a[mid] < key){
                    low = mid + 1;
                } else if (a[mid] > key){
                    high =mid - 1;
                }
            }
            return -1;
        }

        private static int count(int key, int[] a) {
            int num = 1;
            int pos = rank(key, a);
            while (pos < a.length - 1 && a[pos] == a[++pos]) {
                num++;
            }
            return num;
        }
    }
}
