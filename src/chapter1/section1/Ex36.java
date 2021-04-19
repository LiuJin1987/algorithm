package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujinlc
 * @date 2021/4/19 16:37
 **/
public class Ex36 {

    public static void main(String[] args) {
        if (args.length < 2) {
            StdOut.println("Args less than 2");
            return;
        }
        try {
            new ShuffleTest(Integer.parseInt(args[0]), Integer.parseInt(args[1])).testShuffle();
        } catch (NumberFormatException e) {
            StdOut.println("Cannot parse int from args");
        }
    }

    static class ShuffleTest {
        private int arrayLength;
        private int shuffleTimes;

        public ShuffleTest(int arrayLength, int shuffleTimes) {
            this.arrayLength = arrayLength;
            this.shuffleTimes = shuffleTimes;
        }

        public void testShuffle() {
            List<int[]> trialList = new ArrayList<>(shuffleTimes);
            for (int i = 0; i < shuffleTimes; i++) {
                int[] arrayToShuffle = getInitArray(arrayLength).clone();
                StdRandom.shuffle(arrayToShuffle);
                trialList.add(arrayToShuffle);
            }
            printArray(stat(trialList));
        }

        private int[][] stat(List<int[]> trialList) {
            int[][] statArray = new int[arrayLength][arrayLength];
            for (int[] oneTrial : trialList) {
                for (int i = 0; i < oneTrial.length; i++) {
                    statArray[oneTrial[i]][i]++;
                }
            }
            return statArray;
        }

        private void printArray(int[][] array) {
            for (int[] row : array) {
                for (int times : row) {
                    StdOut.printf("%d ", times);
                }
                StdOut.println();
            }
        }

        private static int[] getInitArray(int arrayLength) {
            int[] initArray = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                initArray[i] = i;
            }
            return initArray;
        }
    }
}