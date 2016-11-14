package com.epam.training.matrix;

public class MatrixToArrayConverter {
    public int[][] converter(Matrix matrix) {
        int[][] result = new int[matrix.getRowCount()][matrix.getColumnCount()];
        for (int row = 0; row < matrix.getRowCount(); row++) {
            for (int column = 0; column < matrix.getColumnCount(); column++) {
                result[row][column] = matrix.getElement(row, column);
            }
        }
        return result;
    }
}
