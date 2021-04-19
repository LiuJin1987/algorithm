package chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author liujinlc
 * @date 2021/4/16 16:33
 **/
public class Ex33 {
    private static final Pattern WHITE_SPACE =  Pattern.compile("\\p{javaWhitespace}+");

    public static void main(String[] args) {

        double[][] a = readMatrix("resource/testfiles/chapter1/section1/Ex33_a");
        double[][] b = readMatrix("resource/testfiles/chapter1/section1/Ex33_b");
        double[] x = readVector("resource/testfiles/chapter1/section1/Ex33_x");
        double[] y = readVector("resource/testfiles/chapter1/section1/Ex33_y");

        StdOut.println(Matrix.dot(x, y));
        StdOut.println();

        for (double[] row : Matrix.transpose(a)) {
            for (double d : row) {
                StdOut.printf(d + " ");
            }
            StdOut.println();
        }
        StdOut.println();

        for (double[] row : Matrix.mult(a, b)) {
            for (double d : row) {
                StdOut.printf(d + " ");
            }
            StdOut.println();
        }
        StdOut.println();

        for (double[] row : Matrix.mult(a, x)) {
            for (double d : row) {
                StdOut.printf(d + " ");
            }
            StdOut.println();
        }
        StdOut.println();

        for (double d : Matrix.mult(y, a)) {
            StdOut.printf(d + " ");
        }
        StdOut.println();
    }

    private static double[][] readMatrix(String filePath) {
        if (null == filePath || filePath.isEmpty()) {
            return new double[0][0];
        }
        In in = new In(filePath);
        String line;
        List<double[]> matrixList = new ArrayList<>();
        while (null != (line = in.readLine())) {
            String[] strings = WHITE_SPACE.split(line);
            double[] row = new double[strings.length];
            for (int i = 0; i < strings.length; i++) {
                try {
                    row[i] = Double.parseDouble(strings[i]);
                } catch (NumberFormatException e) {
                    StdOut.println("file contains string that cannot parse to a double");
                    return new double[0][0];
                }
            }
            matrixList.add(row);
        }
        if (matrixList.isEmpty()) {
            return new double[0][0];
        }
        double[][] readInMatrix = new double[matrixList.size()][matrixList.get(0).length];
        for (int i = 0; i < readInMatrix.length; i++) {
            readInMatrix[i] = matrixList.get(i);
        }
        return readInMatrix;
    }

    private static double[] readVector(String filePath) {
        return readMatrix(filePath)[0];
    }
}
