package com.epam.training.matrix;

public class Matrix {
    private int[][] elements;

    public Matrix(int rowCount, int columnCount) {
        this.elements = new int[rowCount][columnCount];
    }

    public int getElement(int row, int column) {
        if (checkField(row, column)) {
            throw new IllegalArgumentException();
        }
        return elements[row][column];
    }

    public void setElement(int element, int row, int column) {
        if (checkField(row, column)) {
            throw new IllegalArgumentException();
        }
        elements[row][column] = element;
    }

    public int getRowCount() {
        return elements.length;
    }

    public int getColumnCount() {
        return elements[0].length;
    }

    private int[] getRow(int rowNumber) {
        return elements[rowNumber];
    }

    private int[] getColumn(int columnNumber) {
        int[] result = new int[getRowCount()];
        for (int rowNumber = 0; rowNumber < getRowCount(); rowNumber++) {
            result[rowNumber] = elements[rowNumber][columnNumber];
        }
        return result;
    }

    private boolean checkMatrix() {
        return (elements == null || elements.length == 0 || elements[0] == null || elements[0].length == 0);
    }

    private boolean checkField(int row, int column) {
        return (((getRowCount() < row) || (getColumnCount() < column)) && ((row < 0) || (column < 0)));
    }

    public Matrix add(Matrix other) {
        if ((getRowCount() != other.getRowCount()) || (getColumnCount() != other.getColumnCount())) {
            throw new IllegalArgumentException();
        }
        Matrix result = new Matrix(getRowCount(), getColumnCount());
        for (int rowNumber = 0; rowNumber < getRowCount(); rowNumber++) {
            for (int columnNumber = 0; columnNumber < getColumnCount(); columnNumber++) {
                result.setElement(elements[rowNumber][columnNumber] + other.getElement(rowNumber, columnNumber), rowNumber, columnNumber);
            }
        }
        return result;
    }

    public int determinant() {
        if (checkMatrix()) {
            throw new IllegalArgumentException();
        }
        int length = elements.length - 1;
        if (length < 0) {
            return 0;
        }
        int tripleArray[][][] = new int[length + 1][][];

        tripleArray[length] = elements;

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

    public Matrix multiply(Matrix right) {
        if (checkMatrix() || right.checkMatrix()) {
            throw new IllegalArgumentException("Illegal matrix  argument");
        }
        if (getColumnCount() != right.getRowCount()) {
            throw new IllegalArgumentException("Matrix can not multiply");
        }
        int[][] result = new int[this.getRowCount()][right.getColumnCount()];
        for (int rowNumber = 0; rowNumber < this.getRowCount(); rowNumber++) {
            for (int columnNumber = 0; columnNumber < right.getColumnCount(); columnNumber++) {
                result[rowNumber][columnNumber] = multiplyVector(this.getRow(rowNumber), right.getColumn(columnNumber));
            }
        }
        return new ArrayToMatrixConverter().converter(result);
    }

    private int multiplyVector(int[] row, int[] column) {
        int result = 0;
        for (int i = 0; i < row.length; i++) {
            result += row[i] * column[i];
        }
        return result;
    }

    public Matrix clone() {
        Matrix result = new Matrix(getRowCount(), getColumnCount());
        for (int rowNumber = 0; rowNumber < getRowCount(); rowNumber++) {
            for (int columnNumber = 0; columnNumber < getColumnCount(); columnNumber++) {
                result.setElement(rowNumber, columnNumber, elements[rowNumber][columnNumber]);
            }
        }
        return result;
    }
}
