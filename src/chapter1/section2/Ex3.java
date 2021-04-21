package chapter1.section2;

import common.util.ArgsChecker;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author liujinlc
 * @date 2021/4/21 14:15
 **/
public class Ex3 {
    static Interval2DExtend[] interval2DExtends;

    public static void main(String[] args) {
        try {
            int intervalCount = Integer.parseInt(args[0]);
            double minCoordinate = Double.parseDouble(args[1]);
            double maxCoordinate = Double.parseDouble(args[2]);

            if (minCoordinate > maxCoordinate) {
                StdOut.println("MinCoordinate(args[1]) is larger than" +
                        " MaxCoordinate(args[2]), swap them:");
                double tmp = minCoordinate;
                minCoordinate = maxCoordinate;
                maxCoordinate = tmp;
            }

            interval2DExtends = new Interval2DTest(
                    intervalCount, minCoordinate, maxCoordinate).generateAll();
            Interval2DTest.draw(interval2DExtends);
            StdOut.printf("Overlaps count: %d%n", Interval2DTest.getOverlapCount(interval2DExtends));
            StdOut.printf("Contains count: %d%n", Interval2DTest.getContainCount(interval2DExtends));
        } catch (ArrayIndexOutOfBoundsException e) {
            StdOut.println("Add an integer args[0], and two double args[1], args[2] to main method and retry");
        }
    }
}

class Interval2DTest {
    private final int intervalNumber;
    private final double intervalSpecMin;
    private final double intervalSpecMax;

    public Interval2DTest(int intervalNumber,
                          double intervalSpecMin,
                          double intervalSpecMax) {
        this.intervalNumber = intervalNumber;
        this.intervalSpecMin = intervalSpecMin;
        this.intervalSpecMax = intervalSpecMax;
    }

    public static void draw(Interval2DExtend[] intervals) {
        for (Interval2DExtend interval : intervals) {
            interval.draw();
        }
    }

    public static int getContainCount(Interval2DExtend[] intervals) {
        int containCount = 0;
        for (Interval2DExtend self : intervals) {
            for (Interval2DExtend other : intervals) {
                if (!self.equals(other) && self.contains(other)) {
                    containCount++;
                }
            }
        }
        return containCount;
    }

    public static int getOverlapCount(Interval2DExtend[] intervals) {
        int overlapCount = 0;
        for (Interval2DExtend self : intervals) {
            for (Interval2DExtend other : intervals) {
                if (!self.equals(other) && self.overlaps(other)) {
                    overlapCount++;
                }
            }
        }
        return overlapCount;
    }

    public Interval2DExtend[] generateAll() {
        Interval2DExtend[] intervals = new Interval2DExtend[intervalNumber];
        for (int i = 0; i < intervalNumber; i++) {
            intervals[i] = generateArea();
        }
        return intervals;
    }

    private Interval2DExtend generateArea() {
        return new Interval2DExtend(generateEdge(), generateEdge());
    }

    private Interval1D generateEdge() {
        double min = StdRandom.uniform(intervalSpecMin, intervalSpecMax);
        return new Interval1D(min, StdRandom.uniform(min, intervalSpecMax));
    }
}

class Interval2DExtend {
    private final Point2D leftTop;
    private final Point2D leftBottom;
    private final Point2D rightTop;
    private final Point2D rightBottom;
    private final Interval2D interval2D;

    public Interval2DExtend(Interval1D x, Interval1D y) {
        this.interval2D = new Interval2D(x, y);
        this.leftTop = new Point2D(x.min(), y.max());
        this.leftBottom = new Point2D(x.min(), y.min());
        this.rightTop = new Point2D(x.max(), y.max());
        this.rightBottom = new Point2D(x.max(), y.min());
    }

    public boolean equals(Interval2DExtend that) {
        return this.interval2D.equals(that.interval2D);
    }

    public void draw() {
        this.interval2D.draw();
    }

    public boolean overlaps(Interval2DExtend that) {
        return !this.contains(that) && (
                this.interval2D.contains(that.rightBottom)
                        || this.interval2D.contains(that.rightTop)
                        || this.interval2D.contains(that.leftTop)
                        || this.interval2D.contains(that.leftBottom));
    }

    public boolean contains(Interval2DExtend that) {
        return this.interval2D.contains(that.leftTop)
                && this.interval2D.contains(that.rightBottom);
    }
}
