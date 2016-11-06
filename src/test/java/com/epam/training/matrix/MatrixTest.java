package com.epam.training.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MatrixTest {
    @Test
    public void testDeterminantWhereThreeByThreeMatrix() throws Exception {
        int[][] left = {
                {9, 8, 7},
                {1, 2, 3},
                {6, 2, 1}};
        int result = 30;
        Matrix matrix = new Matrix(left);
        Assert.assertTrue(matrix.determinant() == result);
    }

    @Test
    public void testDeterminantWhereFourByFourMatrix() {
        int[][] left = {
                {2, 3, 4, 5},
                {2, 3, 4, 9},
                {8, 8, 1, 8},
                {4, 3, 4, 3}};
        int result = -232;
        Matrix matrix = new Matrix(left);
        Assert.assertTrue(matrix.determinant() == result);
    }

    @Test(expected = NullPointerException.class)
    public void determinantWhereMatrixNull() {
        int[][] left = null;
        Matrix matrix = new Matrix(left);
        matrix.determinant();
    }

    @Test
    public void testFold() throws Exception {
        int[][] left = {
                {2, 2, 2, 2},
                {3, 3, 3, 3}};
        int[][] right = {
                {3, 3, 3, 3},
                {4, 4, 4, 4}};
        int[][] result = {
                {5, 5, 5, 5},
                {7, 7, 7, 7}};
        Matrix matrix = new Matrix(left);
        Assert.assertTrue(Arrays.deepEquals(matrix.fold(right), result));
    }

    @Test
    public void testGetElement() throws Exception {
        int[][] left = {
                {2, 3, 4, 5},
                {2, 3, 4, 9},
                {8, 8, 1, 8},
                {4, 3, 4, 3}};
        Matrix matrix = new Matrix(left);
        Assert.assertEquals(matrix.getElement(2, 2), 1);
    }

    @Test
    public void testSetElement() throws Exception {
        int[][] left = {
                {2, 3, 4, 5},
                {2, 3, 4, 9},
                {8, 8, 1, 8},
                {4, 3, 4, 3}};
        int[][] result = {
                {23, 3, 4, 5},
                {2, 3, 4, 9},
                {8, 8, 1, 8},
                {4, 3, 4, 3}};
        Matrix matrix = new Matrix(left);
        matrix.setElement(23, 0, 0);
        Assert.assertTrue(Arrays.deepEquals(matrix.getMatrix(), result));
    }

    @Test
    public void testMultiplication() throws Exception {
        int[][] left = {
                {2, 12, 3},
                {4, 32, 1},
                {2, 9, 10},
                {8, 19, 10}};
        int[][] right = {
                {1, 5, 5, 9},
                {11, 12, 2, 4},
                {12, 1, 31, 15}};
        int[][] result = {
                {170, 157, 127, 111},
                {368, 405, 115, 179},
                {221, 128, 338, 204},
                {337, 278, 388, 298}};
        Matrix matrix = new Matrix(left);
        Assert.assertTrue(Arrays.deepEquals(matrix.multiplication(right), result));
    }
}
