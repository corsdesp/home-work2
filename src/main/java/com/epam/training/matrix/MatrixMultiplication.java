package com.epam.training.matrix;

/**
 * Возвращает перемножение двух матриц типа {@code int}
 */
public class MatrixMultiplication {
    public int[][] multiplication(int[][] left, int[][] right) {
        if (!checkMatrix(left) || !checkMatrix(right)) {
            throw new IllegalArgumentException("1");
        }
        if (getColumnCount(left) != getRowCount(right)) {
            throw new IllegalArgumentException("2");
        }
        int[][] result = new int[getRowCount(left)][getColumnCount(right)];
        for (int rowNumber = 0; rowNumber < getRowCount(left); rowNumber++) {
            for (int columnNumber = 0; columnNumber < getColumnCount(right); columnNumber++) {
                result[rowNumber][columnNumber] = multiplyVector(getRow(left, rowNumber), getColumn(right, columnNumber));
            }
        }
        return result;
    }

    private int multiplyVector(int[] row, int[] column) {
        int result = 0;
        for (int i = 0; i < row.length; i++) {
            result += row[i] * column[i];
        }
        return result;
    }

    private int[] getRow(int[][] left, int rowNumber) {
        return left[rowNumber];
    }

    private int[] getColumn(int[][] matrix, int columnNumber) {
        int[] result = new int[getRowCount(matrix)];
        for (int rowNumber = 0; rowNumber < getRowCount(matrix); rowNumber++) {
            result[rowNumber] = matrix[rowNumber][columnNumber];
        }
        return result;
    }

    private int getRowCount(int[][] matrix) {
        return matrix.length;
    }

    private int getColumnCount(int[][] matrix) {
        return matrix[0].length;
    }

    private boolean checkMatrix(int[][] matrix) {
        return !(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0);
    }
}
