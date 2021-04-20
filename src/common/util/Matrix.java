package common.util;

/**
 * @author liujinlc
 * @date 2021/4/16 16:35
 **/
@SuppressWarnings("all")
public class Matrix {
    public static double dot(double[] x, double[] y) {
        if (null == x || null == y || x.length != y.length) {
            return 0.0;
        }
        double dotValue = 0.0;
        for (int i = 0; i < x.length; i++) {
            dotValue = dotValue + x[i] * y[i];
        }
        return dotValue;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        if (a == null || b == null || a.length <= 0 || b.length <= 0 || a[0].length != b.length) {
            return null;
        }
        double[][] mult = new double[a.length][b[0].length];
        for (int i = 0; i < mult.length; i++) {
            for (int j = 0; j < mult[i].length; j++) {
                mult[i][j] = mult[i][j] + dot(a[i], transpose(b)[j]);
            }
        }
        return mult;
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
        if (a == null || x == null || a[0].length != x.length) {
            return null;
        }
        double[][] result = new double[a.length][1];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = result[i][0] + dot(a[i], x);
        }
        return result;
    }

    public static double[] mult(double[] y, double[][] a) {
        if (a == null || y == null || a[0].length != y.length) {
            return null;
        }
        double[] result = new double[y.length];
        for (int i = 0; i < y.length; i++) {
            result[i] = dot(y, transpose(a)[i]);
        }
        return result;
    }
}
