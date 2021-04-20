package chapter1.section2;

import common.util.ArgsChecker;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author liujinlc
 * @date 2021/4/21 10:06
 **/
public class Ex1 {
    public static void main(String[] args) {
        ArgsChecker.checkArgs(() -> {
            int pointNum = Integer.parseInt(args[0]);
            StdOut.printf(
                    "Minimal distance in %d random 2D points is: %.4f%n",
                    pointNum,
                    Point2DTest.calculateMinimalDistance(
                            new Point2DTest(pointNum).generateRandomPoints()));
        }, "Add an integer args[0] to main method and retry");
    }
}

class Point2DTest {
    private final int pointNum;

    public Point2DTest(int pointNum) {
        this.pointNum = pointNum;
    }

    public static double calculateMinimalDistance(Point2D[] points) {
        double minimalDistance = 1.5;
        for (Point2D pointFrom : points) {
            for (Point2D pointTo: points) {
                double distanceBetween = pointFrom.distanceTo(pointTo);
                if (distanceBetween > 0.0 && distanceBetween < minimalDistance) {
                    minimalDistance = distanceBetween;
                }
            }
        }
        return minimalDistance;
    }

    public Point2D[] generateRandomPoints() {
        Point2D[] randomPoints = new Point2D[pointNum];
        for (int i = 0; i < pointNum; i++) {
            randomPoints[i] = new Point2D(
                    StdRandom.uniform(0.0, 1.0),
                    StdRandom.uniform(0.0, 1.0));
        }
        return randomPoints;
    }
}
