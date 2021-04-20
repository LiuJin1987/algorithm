package chapter1.section1;

import common.util.ArrayPrinter;
import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * @author liujinlc
 * @date 2021/4/20 9:00
 **/
public class Ex38 {

    public static void main(String[] args) {

        String largeW = "resource/testfiles/algs4-data/largeW.txt";
        String largeT = "resource/testfiles/algs4-data/largeT.txt";

        In wInput = new In(largeW);
        In tInput = new In(largeT);

        int[] wArray = wInput.readAllInts();
        int[] tArray = tInput.readAllInts();

        StdOut.println("Input an integer to search:");
        int toSearch = StdIn.readInt();

        long beforeBinarySearch = System.currentTimeMillis();
        Arrays.sort(wArray);
        StdOut.printf("%d %s found in w array%n", toSearch,
                BinarySearch.indexOf(wArray, toSearch) != -1 ? "" : "not");
        long afterBinarySearchInW = System.currentTimeMillis();
        StdOut.printf("BinarySearch in w array cost %d ms%n", (afterBinarySearchInW - beforeBinarySearch));

        Arrays.sort(tArray);
        StdOut.printf("%d %s found in t array%n", toSearch,
                BinarySearch.indexOf(tArray, toSearch) != -1 ? "" : "not");
        long afterBinarySearchInT = System.currentTimeMillis();
        StdOut.printf("BinarySearch in t array cost %d ms%n", (afterBinarySearchInT - afterBinarySearchInW));

        long beforeForceSearch = System.currentTimeMillis();
        StdOut.printf("%d %s found in w array%n", toSearch,
                BruteForceSearch.indexOf(wArray, toSearch) != -1 ? "" : "not");
        long afterForceSearchInW = System.currentTimeMillis();
        StdOut.printf("ForceSearch in w array cost %d ms%n", (afterForceSearchInW - beforeForceSearch));

        StdOut.printf("%d %s found in t array%n", toSearch,
                BinarySearch.indexOf(tArray, toSearch) != -1 ? "" : "not");
        long afterForceSearchInT = System.currentTimeMillis();
        StdOut.printf("ForceSearch in t array cost %d ms%n", (afterForceSearchInT - afterForceSearchInW));

        StdOut.println();
    }

    static class BruteForceSearch {
        public static int indexOf(int[] array, int key) {
            for (int i = 0; i < array.length; i++) {
                if (key == array[i]) {
                    return i;
                }
            }
            return 0;
        }
    }
}
