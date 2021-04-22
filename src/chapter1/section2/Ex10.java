package chapter1.section2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.Color;

/**
 * @author liujinlc
 * @date 2021/4/22 17:32
 **/
public class Ex10 {
    public static void main(String[] args) {
        VisualCounter counter = new VisualCounter(20, 30);
        for (int i = 0; i < 100; i++) {
            double random = StdRandom.uniform(0.0, 1.0);
            if (random > 0.5) {
                counter.addOne();
            } else {
                counter.minusOne();
            }
            counter.print();
        }
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.line(0.0, 0.5, 1.0, 0.5);
    }
}

class VisualCounter {
    private final long maxOperationTimes;
    private final long maxCounterAbsValue;
    private long counterValue;
    private long operationTimes;

    public VisualCounter(long maxOperationTimes, long maxCounterAbsValue) {
        this.maxOperationTimes = maxOperationTimes;
        this.maxCounterAbsValue = maxCounterAbsValue;
    }

    public void print() {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(Color.RED);
        new Point2D((this.operationTimes + 0.0) / this.maxOperationTimes,
                (this.counterValue + 0.0) / this.maxCounterAbsValue + 0.5).draw();
    }

    public void addOne() {
        if (operationTimes < maxOperationTimes && Math.abs(counterValue) < maxCounterAbsValue) {
            operationTimes++;
            counterValue++;
        }
    }

    public void minusOne() {
        if (operationTimes < maxOperationTimes && Math.abs(counterValue) < maxCounterAbsValue) {
            operationTimes++;
            counterValue--;
        }
    }
}