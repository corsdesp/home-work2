package com.epam.training.matrix;

public class Matrix {
    private int[][] left;
    private int rowCount;
    private int columnCount;

    public Matrix(int[][] left) {
        this.left = left;
    }

    public Matrix(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.left = new int[rowCount][columnCount];
    }

    public int[][] getMatrix() {
        return left;
    }

    public int getElement(int row, int column) {
        if (checkMatrixField(row, column)) {
            throw new IllegalArgumentException();
        }
        return left[row][column];
    }

    public void setElement(int element, int row, int column) {
        if (checkMatrixField(row, column)) {
            throw new IllegalArgumentException();
        }
        left[row][column] = element;
    }

    private boolean checkMatrixField(int row, int column) {
        return ((getRowCount(left) < row) || (getColumnCount(left) < column)) && ((row < 0) || (column < 0));
    }

    public int[][] fold(int[][] right) {
        if (checkMatrix(left) || checkMatrix(right)) {
            return left;
        }
        if ((getRowCount(left) != getRowCount(right)) || (getColumnCount(left) != getColumnCount(right))) {
            throw new IllegalArgumentException();
        }
        int[][] result = new int[getRowCount(left)][getColumnCount(left)];
        for (int rowNumber = 0; rowNumber < getRowCount(left); rowNumber++) {
            for (int columnNumber = 0; columnNumber < getColumnCount(left); columnNumber++) {
                result[rowNumber][columnNumber] = left[rowNumber][columnNumber] + right[rowNumber][columnNumber];
            }
        }
        return result;
    }

    private boolean checkMatrix(int[][] matrix) {
        return (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0);
    }

    private int getRowCount(int[][] matrix) {
        return matrix.length;
    }

    private int getColumnCount(int[][] matrix) {
        return matrix[0].length;
    }

    public int determinant() {
        if (checkMatrix(left)) {
            throw new NullPointerException();
        }
        int length = left.length - 1;
        if (length < 0) {
            return 0;
        }
        int tripleArray[][][] = new int[length + 1][][];

        tripleArray[length] = left;

        for (int i = 0; i < length; i++) {
            tripleArray[i] = new int[i + 1][i + 1];
        }
        return determinant(tripleArray, length);
    }

    private int determinant(int[][][] tripleArray, int length) {
        if (length == 0) {
            return tripleArray[0][0][0];
        }
        int sign = 1;

        for (int i = 0; i < length; i++) {
            System.arraycopy(tripleArray[length][i], 0, tripleArray[length - 1][i], 0, length);
        }
        int result = tripleArray[length][length][length] * determinant(tripleArray, length - 1);

        for (int i = length - 1; i >= 0; i--) {
            System.arraycopy(tripleArray[length][i + 1], 0, tripleArray[length - 1][i], 0, length);
            sign = -sign;
            result += sign * tripleArray[length][i][length] * determinant(tripleArray, length - 1);
        }
        return result;
    }

    public int[][] multiplication(int[][] right) {
        if (checkMatrix(left) || checkMatrix(right)) {
            throw new IllegalArgumentException("Illegal matrix  argument");
        }
        if (getColumnCount(left) != getRowCount(right)) {
            throw new IllegalArgumentException("Matrix can not multiply");
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
}
