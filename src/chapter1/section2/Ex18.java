package chapter1.section2;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/25 16:25
 **/
public class Ex18 {
    public static void main(String[] args) {
        double[] doubles = new In("resource/testfiles/chapter1/section2/accumulator.txt").readAllDoubles();
        Accumulator stats = new Accumulator();
        double mean = 0.0;
        for (double d : doubles) {
            stats.addDataValue(d);
            mean = mean + d;
        }
        mean = mean / doubles.length;
        double sumPow = 0.0;
        for (double d : doubles) {
            sumPow = (d - mean) * (d - mean);
        }
        double sumSqrt = Math.sqrt(sumPow / doubles.length);
        StdOut.println(sumSqrt);
        StdOut.println(stats.stddev());
    }
}
