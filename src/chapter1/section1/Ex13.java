package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Ex13 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[][] transposed = transpose(matrix);
        for (int[] row : transposed) {
            for (int element : row) {
                StdOut.print(element + " ");
            }
            StdOut.println();
        }        
    }

    private static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] transposed = new int[col][row]; 
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }
}
