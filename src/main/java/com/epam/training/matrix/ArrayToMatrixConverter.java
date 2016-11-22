package com.epam.training.matrix;

public class ArrayToMatrixConverter {
    public Matrix converter(int[][] elements) {
        Matrix result = new Matrix(getRowCount(elements), getColumnCount(elements));
        for (int row = 0; row < getRowCount(elements); row++) {
            for (int column = 0; column < getColumnCount(elements); column++) {
                result.setElement(elements[row][column], row, column);
            }
        }
        return result;
    }

    private int getRowCount(int[][] elements) {
        return elements.length;
    }

    private int getColumnCount(int[][] elements) {
        return elements[0].length;
    }
}
