package com.epam.training.matrix;

public class Matrix {
    private int[][] left;

    public Matrix(int[][] left) {
        this.left = left;
    }

    public int[][] getMatrix() {
        return left;
    }

    public void setMatrix(int[][] left) {
        this.left = left;
    }

    public int getElement(int row, int column) {
        if (((getRowCount(left) < row) || (getColumnCount(left) < column)) && ((row < 0) || (column < 0))) {
            throw new IllegalArgumentException();
        }
        return left[row][column];
    }

    public void setElement(int element, int row, int column) {
        left[row][column] = element;
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

    public int[][] multiplication(int[][] right) {
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
        return matrixMultiplication.multiplication(left, right);
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
        if (length < 0) return 0;
        int tripleArray[][][] = new int[length + 1][][];

        tripleArray[length] = left;

        for (int i = 0; i < length; i++) {
            tripleArray[i] = new int[i + 1][i + 1];
        }
        return determinant(tripleArray, length);
    }

    private int determinant(int[][][] tripleMatrix, int length) {
        if (length == 0) return tripleMatrix[0][0][0];
        int sign = 1;

        for (int i = 0; i < length; i++) {
            System.arraycopy(tripleMatrix[length][i], 0, tripleMatrix[length - 1][i], 0, length);
        }
        int result = tripleMatrix[length][length][length] * determinant(tripleMatrix, length - 1);

        for (int i = length - 1; i >= 0; i--) {
            System.arraycopy(tripleMatrix[length][i + 1], 0, tripleMatrix[length - 1][i], 0, length);
            sign = -sign;
            result += sign * tripleMatrix[length][i][length] * determinant(tripleMatrix, length - 1);
        }
        return result;
    }
}
