package chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liujinlc
 * @date 2021/4/16 9:47
 **/
public class Ex32 {
    /**
     * run with args like: java Ex32.java 4 1.0 5.0
     * @param args args like: java Ex32.java 4 1.0 5.0
     */
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);

        if (r < l) {
            double t = r;
            r = l;
            l = t;
        }
        double lengthBetween = (r - l) / N;
        Map<HorizontalLine, Integer> lineMap = initHistogramTimes(N, l, lengthBetween);

        StdOut.print("Input doubles splited by spaces:");
        List<Double> doubles = new ArrayList<>();

        /*
        StdIn.readAllDoubles() dose not work
         */
        String inputString;
        while (!"0.0".equals(inputString = StdIn.readString())) {
            doubles.add(Double.parseDouble(inputString));
        }
        fillHistogramTimes(lineMap, doubles);

        //drawHistogram(lineMap, l, r);

        /*StdDraw.filledRectangle(0.1, 0, 0.1, 0.3);
        StdDraw.filledRectangle(0.3, 0, 0.1, 0.5);
        StdDraw.filledRectangle(0.5, 0, 0.1, 0.8);*/
        StdDraw.filledRectangle(0.25, 0, 0.25, 0.5);
    }

    private static void fillHistogramTimes(Map<HorizontalLine, Integer> lineMap, List<Double> doubles) {
        for (double aDouble : doubles) {
            lineMap.forEach((horizontalLine, times) -> {
                if (horizontalLine.inLine(aDouble)) {
                    lineMap.put(horizontalLine, ++times);
                }
            });
        }
    }

    private static Map<HorizontalLine, Integer> initHistogramTimes(int N, double l, double lengthBetween) {
        Map<HorizontalLine, Integer> lineMap = new HashMap<>(N * 4 / 3 + 1);
        for (int i = 0; i < N; i++) {
            HorizontalLine line = new HorizontalLine(l + i * lengthBetween, l + (i + 1) * lengthBetween);
            lineMap.put(line, 0);
        }
        return lineMap;
    }

    private static void drawHistogram(Map<HorizontalLine, Integer> lineMap, double L, double R) {
        if (lineMap.isEmpty()) {
            return;
        }
        
        StdDraw.setPenRadius(0.01);

        int max = 0;

        for (Map.Entry<HorizontalLine, Integer> entry : lineMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        for (Map.Entry<HorizontalLine, Integer> entry : lineMap.entrySet()) {
            double halfWidth = (entry.getKey().getEnd() - entry.getKey().getBegin()) / (R - L) / 2;
            double height = (entry.getValue() + 0.0) / max;
            double x = (entry.getKey().getBegin() - L) / (R - L) + halfWidth;
            /*
            fill by percentage, an StdDraw.filledRectangle(0.5, 0.0, 0.5, 1.0) call
            will fill all the window while an an StdDraw.filledRectangle(0.25, 0.0, 0.25, 0.5) call
            will only fill the left down quarter of the window:
            x is horizontal center of filling part,
            y is vertical base of filling part,
            halfWidth is halfWidth of filling part,
            height is total height of filling part
             */
            StdDraw.filledRectangle(x, 0.0, halfWidth, height);
        }
    }

    static class HorizontalLine {
        private double begin;
        private double end;

        public HorizontalLine(double begin, double end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof HorizontalLine)) {
                return false;
            }
            HorizontalLine toCompare = (HorizontalLine) object;
            return this.begin == toCompare.begin && this.end == toCompare.end;
        }

        @Override
        public int hashCode() {
            return (int) ((31 * this.begin + 31 * this.end) * 100);
        }

        public double getBegin() {
            return this.begin;
        }

        public double getEnd() {
            return this.end;
        }

        public boolean inLine(double y) {
            return this.begin <= y && y < this.end;
        }
    }
}
