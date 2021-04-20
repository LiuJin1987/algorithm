package chapter1.section1;

import common.util.ArrayPrinter;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author liujinlc
 * @date 2021/4/19 16:37
 **/
public class Ex36 {

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Args less than 2");
        }
        try {
            new ShuffleTest(Integer.parseInt(args[0]), Integer.parseInt(args[1]))
                    .testShuffle(StdRandom::shuffle);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Cannot parse int from args");
        }
    }

    public static class ShuffleTest {
        private final int arrayLength;
        private final int shuffleTimes;

        public ShuffleTest(int arrayLength, int shuffleTimes) {
            this.arrayLength = arrayLength;
            this.shuffleTimes = shuffleTimes;
        }

        public void testShuffle(Consumer<int[]> shuffleFunc) {
            List<int[]> trialList = new ArrayList<>(shuffleTimes);
            for (int i = 0; i < shuffleTimes; i++) {
                int[] arrayToShuffle = getInitArray(arrayLength).clone();
                shuffleFunc.accept(arrayToShuffle);
                trialList.add(arrayToShuffle);
            }
            ArrayPrinter.print(stat(trialList));
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

        private static int[] getInitArray(int arrayLength) {
            int[] initArray = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                initArray[i] = i;
            }
            return initArray;
        }
    }
}