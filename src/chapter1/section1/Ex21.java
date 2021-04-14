package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * @author liujinlc
 * @date 2021/4/14 15:22
 **/
public class Ex21 {
    public static void main(String[] args) {
        printTable(storeTable());
    }

    private static void printTable(List<LineData> storedTable) {
        StdOut.println("name" + "\t" + "numerator" + "\t" + "denominator" + "\t" + "result");
        storedTable.forEach(StdOut::println);
    }

    private static List<LineData> storeTable() {
        List<LineData> tableData = new ArrayList<>();
        String inputLine;
        while (!"exit".equals(inputLine = StdIn.readLine())) {
            String[] lineText = inputLine.split(" ");
            if (lineText.length >= 3) {
                tableData.add(getLineData(lineText));
            }
        }
        return tableData;
    }

    /**
     * NOTICE that double will auto trim suffix 0,
     * eg: a "1.000" string will be cast to "1.0" when parse to double
     * so we must use String type to save double value or only use formatting
     * when doing output
     */
    private static LineData getLineData(String[] lineText) {
        LineData lineData = new LineData();
        if (lineText.length >= 3) {
            lineData.name = lineText[0];
            lineData.numerator = Double.valueOf(lineText[1]);
            lineData.denominator = Double.valueOf(lineText[2]);
            lineData.result = lineData.numerator / lineData.denominator;
        }
        return lineData;
    }

    static class LineData {
        private String name;
        private Double numerator;
        private Double denominator;
        private Double result;

        @Override
        public String toString() {
            /*DecimalFormat decimalFormat = new DecimalFormat("#,###.000");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);*/
            return String.format("%s\t%.3f\t%.3f\t%.3f", name, numerator, denominator, result);
        }
    }
}
