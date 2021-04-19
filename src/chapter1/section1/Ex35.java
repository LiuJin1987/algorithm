package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;

/**
 * @author liujinlc
 * @date 2021/4/19 11:04
 **/
public class Ex35 {

    private static final int MIN_TIMES_TO_JUDGE = 10000;
    /**
     * 134217728 = 2 ^ 30 / 2 ^ 3;
     * 2 ^ 30 = 2 ^ 10 * 2 ^ 10 * 2 ^ 10 = 1GB;
     * 2 ^ 3 = 8B = a double size
     */
    private static final int MAX_TIMES_TO_JUDGE = 134217728;

    public static void main(String[] args) {
        printRandomMinimalTimesToMatch();
    }

    private static void printRandomMinimalTimesToMatch() {
        for (int trialTimes = MIN_TIMES_TO_JUDGE; trialTimes < MAX_TIMES_TO_JUDGE; trialTimes++) {
            if (judgeMatches(trialTimes)) {
                StdOut.printf(
                        "TrialTimes matches theoryTimes in 0.001 margin of error by %d times trial this time.%n",
                        trialTimes);
                break;
            }
        }
    }

    private static boolean judgeMatches(int trialTimes) {
        Dice dice = new Dice();
        double[] trialProbabilityResults = dice.multiTrialProbability(trialTimes);
        for (int i = 0; i < trialProbabilityResults.length; i++) {
            if (!dice.match(dice.sumOfTwo()[i], trialProbabilityResults[i])) {
                return false;
            }
        }
        return true;
    }

    static class Dice {
        private static final int SIDES = 6;

        public double[] sumOfTwo() {
            double[] dist = new double[2 * SIDES + 1];
            for (int i = 1; i <= SIDES; i++) {
                for (int j = 1; j <= SIDES; j++) {
                    dist[i + j] += 1.0;
                }
            }
            for (int k = 2; k <= 2 * SIDES; k++) {
                dist[k] /= 36.0;
            }
            return dist;
        }

        public int roll() {
            return StdRandom.uniform(1, 7);
        }

        public int oneTrial() {
            return roll() + roll();
        }

        private int[] multiTrial(int trialTimes) {
            int[] results = new int[trialTimes];
            for (int i = 0; i < results.length; i++) {
                results[i] = oneTrial();
            }
            return results;
        }

        public double[] multiTrialProbability(int multiTrialTimes) {
            double[] multiTrialProbability = new double[13];
            HashMap<Integer, Integer> trialMap = new HashMap<>();
            int sumTimes = 0;
            for (int trialResult : multiTrial(multiTrialTimes)) {
                if (!trialMap.containsKey(trialResult)) {
                    trialMap.put(trialResult, 1);
                } else {
                    trialMap.put(trialResult, trialMap.get(trialResult) + 1);
                }
                sumTimes++;
            }
            final double totalTimes = sumTimes;
            trialMap.forEach((k, v) -> multiTrialProbability[k] = v / totalTimes);
            return multiTrialProbability;
        }

        public boolean match(double theoryProbability, double trialProbability) {
            return Math.abs(theoryProbability - trialProbability) < 0.001;
        }
    }
}
