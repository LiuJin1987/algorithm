package chapter1.section2;

import common.util.ArgsChecker;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;

/**
 * @author liujinlc
 * @date 2021/4/21 14:15
 **/
public class Ex3 {

    public static void main(String[] args) {

        ArgsChecker.checkArgs(() -> {
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

                    Interval2DExtend[] interval2DExtends = new Interval2DTest(
                            intervalCount, minCoordinate, maxCoordinate).generateAll();
                    Interval2DTest.draw(interval2DExtends);
                    StdOut.printf("Overlaps count: %d%n", Interval2DTest.getOverlapCount(interval2DExtends));
                    StdOut.printf("Contains count: %d%n", Interval2DTest.getContainCount(interval2DExtends));
                },
                "Add an integer args[0], and two double args[1], args[2] to main method and retry");
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

    /**
     * Get contains count from intervals
     *
     * There is no need to remove duplication because there is no
     * "contains each-other" relationship unless the interval is its self
     *
     * @param intervals     Interval2DExtend array contains Interval2DExtends to get contains count
     * @return contains count
     */
    public static int getContainCount(Interval2DExtend[] intervals) {
        int containCount = 0;
        for (Interval2DExtend self : intervals) {
            for (Interval2DExtend other : intervals) {
                if (notSelf(self, other) && self.contains(other)) {
                    containCount++;
                }
            }
        }
        return containCount;
    }

    /**
     *  Get overlap count from intervals
     *
     *  Introduce a overlap map to remove duplicate overlap relationship
     *  when two interval contains each other by overlapping each other's
     *  one corner likes below:
     *               ______________________
     *              |                     |
     *              |                     |
     *  ____________|___________          |
     *  |           |          |          |
     *  |           |          |          |
     *  |           |__________|__________|
     *  |                      |
     *  |                      |
     *  ________________________
     *
     * @param intervals     Interval2DExtend array contains Interval2DExtends to get overlap count
     * @return overlap count
     */
    public static int getOverlapCount(Interval2DExtend[] intervals) {

        HashMap<Interval2DExtend, Interval2DExtend> overlapMap =
                new HashMap<>(intervals.length / 3 * 4 + 1);
        for (Interval2DExtend self : intervals) {
            for (Interval2DExtend other : intervals) {
                if (notSelf(self, other) && isOneWayOverlap(overlapMap, self, other)) {
                    overlapMap.put(self, other);
                }
            }
        }
        return overlapMap.size();
    }

    private static boolean isOneWayOverlap(HashMap<Interval2DExtend, Interval2DExtend> overlapMap,
                                           Interval2DExtend self,
                                           Interval2DExtend other) {
        return isOverlaps(self, other) && notRecorded(overlapMap, other);
    }

    private static boolean notRecorded(HashMap<Interval2DExtend, Interval2DExtend> overlapMap,
                                       Interval2DExtend other) {
        return !overlapMap.containsKey(other);
    }

    private static boolean isOverlaps(Interval2DExtend self, Interval2DExtend other) {
        return self.overlaps(other);
    }

    private static boolean notSelf(Interval2DExtend self, Interval2DExtend other) {
        return !self.equals(other);
    }

    public Interval2DExtend[] generateAll() {
        Interval2DExtend[] intervals = new Interval2DExtend[intervalNumber];
        for (int i = 0; i < intervalNumber; i++) {
            intervals[i] = generateArea();
        }
        /*Interval2DExtend[] intervals = new Interval2DExtend[3];
        intervals[0] = new Interval2DExtend(new Interval1D(0.3, 0.5), new Interval1D(0.2, 0.5));
        intervals[1] = new Interval2DExtend(new Interval1D(0.6, 0.7), new Interval1D(0.1, 0.4));
        intervals[2] = new Interval2DExtend(new Interval1D(0.4, 0.8), new Interval1D(0.3, 0.6));*/
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


    @Override
    public boolean equals(Object that) {
        if (!(that instanceof Interval2DExtend)) {
            return false;
        }
        return this.interval2D.equals(((Interval2DExtend)that).interval2D);
    }

    @Override
    public int hashCode() {
        return this.interval2D.hashCode();
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
