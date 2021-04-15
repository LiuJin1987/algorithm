package chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author liujinlc
 * @date 2021/4/15 10:59
 **/
public class Ex28 {
    public static void main(String[] args) {
        StdOut.print("Input white list filepath:");
        // resource/testfiles/chapter1/section1/Ex28.txt
        String path = StdIn.readString();
        /*for (int i : removeDuplicateWithSet(path)) {
            StdOut.println(i);
        }*/
        for (int i : removeDuplicateWithBinarySearch(path)) {
            StdOut.println(i);
        }
    }

    private static List<Integer> removeDuplicateWithBinarySearch(String whiteListFile) {
        In in = new In(whiteListFile);
        int[] whiteArray = in.readAllInts();
        List<Integer> whiteList = new LinkedList<>();
        for (int i : whiteArray) {
            whiteList.add(i);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i : whiteList) {
            if (resultList.isEmpty()
                    || BinarySearch.rank(i, resultList, 0, resultList.size() - 1) == -1) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    private static Integer[] removeDuplicateWithSet(String whiteListFile) {
        In in = new In(whiteListFile);
        int[] whiteList = in.readAllInts();
        Arrays.sort(whiteList);
        Set<Integer> set = new HashSet<>();
        for (int i : whiteList) {
            set.add(i);
        }
        Integer[] a = new Integer[set.size()];
        return set.toArray(a);
    }
}
