package chapter1.section1;

/**
 * @author liujinlc
 * @date 2021/4/16 16:35
 **/
public class Matrix {
    public static double dot(double[] x, double[] y) {
        if (null == x || null == y || x.length != y.length) {
            return 0.0;
        }
        double dotValue = 0.0;
        for (int i = 0; i < x.length; i++) {
            dotValue = dotValue + x[i] + y[i];
        }
        return dotValue;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        return null;
    }

    public static double[][] transpose(double[][] a) {
        if (a == null) {
            return null;
        }
        int rowNum = a.length;
        int colNum = a[0].length;
        double[][] transposed = new double[colNum][rowNum];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                transposed[j][i] = a[i][j];
            }
        }
        return transposed;
    }

    public static double[][] mult(double[][] a, double[] x) {
        return null;
    }

    public static double[] mult(double[] y, double[][] a) {
        return null;
    }
}
