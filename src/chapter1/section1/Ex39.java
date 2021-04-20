package chapter1.section1;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liujinlc
 * @date 2021/4/20 9:07
 **/
public class Ex39 {
    public static void main(String[] args) {
        RandomMatch randomMatch = null;
        try {
            randomMatch = new RandomMatch(
                    Integer.parseInt(args[0]),
                    new int[] {(int) 1e3, (int) 1e4, (int) 1e5, (int) 1e6});
        } catch (ArrayIndexOutOfBoundsException e) {
            StdOut.println("Should give a legal args[0] as trial times, bye bye!");
        }
        if (randomMatch != null) {
            randomMatch.printMap(randomMatch.test());
        }
    }

    static class RandomMatch {
        private int trialTimes;
        private int[] numberCountArray;

        public RandomMatch(int trialTimes, int[] numberCountArray) {
            this.trialTimes = trialTimes;
            this.numberCountArray = numberCountArray;
        }

        public Map<Integer, Double> test() {
            Map<Integer, Double> testMap = new HashMap<>(numberCountArray.length / 3 * 4 + 1);
            for (int numberCount : numberCountArray) {
                testMap.put(numberCount, getAverageCount(numberCount));
            }
            return testMap;
        }

        public void printMap(Map<Integer, Double> mapToPrint) {
            mapToPrint.forEach((k, v) -> StdOut.printf("NumberArraySize: %d, AverageMatchCount: %.2f%n", k, v));
        }

        private double getAverageCount(int arrayLength) {
            double averageCount = 0.0;
            for (int i = 0; i < trialTimes; i++) {
                averageCount += bothExistCount(
                        generateRandomArray(arrayLength),
                        generateRandomArray(arrayLength));
            }
            return averageCount / trialTimes;
        }

        private int bothExistCount(int[] array1, int[] array2) {
            Set<Integer> set = new HashSet<>(array1.length / 3 * 4 + 1);
            for (int element : array1) {
                set.add(element);
            }
            int bothExistCount = 0;
            for (Integer i : set) {
                if (BinarySearch.indexOf(array2, i) != -1) {
                    bothExistCount++;
                }
            }
            return bothExistCount;
        }

        private int[] generateRandomArray(int arrayLength) {
            int[] randomArray = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                randomArray[i] = StdRandom.uniform(0, 1000000);
            }
            return randomArray;
        }
    }
}
