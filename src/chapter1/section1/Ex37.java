package chapter1.section1;

import static edu.princeton.cs.algs4.StdRandom.uniform;

/**
 * @author liujinlc
 * @date 2021/4/19 17:36
 **/
public class Ex37 {

    public static void main(String[] args) {
        Ex36.ShuffleTest shuffleTest = new Ex36.ShuffleTest(10, 5);
        shuffleTest.testShuffle(Ex37.AwfulShuffle::shuffle);
    }

    static class AwfulShuffle {
        public static void shuffle(int[] a) {
            validateNotNull(a);
            int n = a.length;
            for (int i = 0; i < n; i++) {
                int r = uniform(n);     // between 0 and n-1
                int temp = a[i];
                a[i] = a[r];
                a[r] = temp;
            }
        }

        private static void validateNotNull(Object x) {
            if (x == null) {
                throw new IllegalArgumentException("argument must not be null");
            }
        }
    }
}
