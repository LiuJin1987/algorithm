package chapter1.section2;

import common.util.ArgsChecker;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujinlc
 * @date 2021/4/21 10:28
 **/
public class Ex2 {
    public static void main(String[] args) {
        ArgsChecker.checkArgs(() ->
                Interval1DTest.print(new Interval1DTest(Integer.parseInt(args[0])).getOverlapIntervals()),
                "Add an integer args[0] to main method and retry");
    }
}

class Interval1DTest {
    private final int intervalNums;
    private final Interval1D[] intervals;

    public Interval1DTest(int intervalNums) {
        this.intervalNums = intervalNums;
        this.intervals = readIntervals(intervalNums);
    }

    public static void print(List<Interval1D[]> overlapIntervals) {
        for (Interval1D[] intervalPair : overlapIntervals) {
            StdOut.printf("%s interval overlaps %s interval%n",
                    intervalPair[0].toString(),
                    intervalPair[1].toString());
        }
    }

    public List<Interval1D[]> getOverlapIntervals() {
        List<Interval1D[]> list = new ArrayList<>();
        for (int i = 0; i < intervalNums; i++) {
            for (int j = 0; j < intervalNums; j++) {
                if (isNotSelf(intervals[i], intervals[j]) && isOverlap(intervals[i], intervals[j])) {
                    list.add(new Interval1D[] {intervals[i], intervals[j]});
                }
            }
        }
        return list;
    }

    private static boolean isNotSelf(Interval1D intervalThis, Interval1D intervalThat) {
        return !intervalThat.equals(intervalThis);
    }

    private static boolean isOverlap(Interval1D intervalThis, Interval1D intervalThat) {
        return intervalThat.contains(intervalThis.min())
                || intervalThat.contains(intervalThis.max())
                || intervalThis.contains(intervalThat.min())
                || intervalThis.contains(intervalThat.max());
    }

    private static Interval1D[] readIntervals(int intervalNums) {
        Interval1D[] intervals = new Interval1D[intervalNums];
        for (int i = 0; i < intervalNums; i++) {
            StdOut.println("Input the begin coordinate:");
            double begin = StdIn.readDouble();
            StdOut.println("Input the end coordinate:");
            double end = StdIn.readDouble();
            if (begin > end) {
                StdOut.println("Begin coordinate is larger than end coordinate, swap:");
                intervals[i] = new Interval1D(end, begin);
            } else {
                intervals[i] = new Interval1D(begin, end);
            }
        }
        return intervals;
    }
}