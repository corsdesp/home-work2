package com.epam.training.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MatrixTest {
    @Test
    public void testDeterminantWhereThreeByThreeMatrix() throws Exception {
        int[][] array = {
                {9, 8, 7},
                {1, 2, 3},
                {6, 2, 1}};
        int result = 30;
        Matrix matrix = new ArrayToMatrixConverter().converter(array);
        Assert.assertTrue(matrix.determinant() == result);
    }

    @Test
    public void testDeterminantWhereFourByFourMatrix() {
        int[][] array = {
                {2, 3, 4, 5},
                {2, 3, 4, 9},
                {8, 8, 1, 8},
                {4, 3, 4, 3}};
        int result = -232;
        Matrix matrix = new ArrayToMatrixConverter().converter(array);
        Assert.assertTrue(matrix.determinant() == result);
    }

    @Test(expected = NullPointerException.class)
    public void determinantWhereMatrixNull() {
        int[][] array = null;
        Matrix matrix = new ArrayToMatrixConverter().converter(array);
        matrix.determinant();
    }

    @Test
    public void testAdd() throws Exception {
        int[][] firstArray = {
                {2, 2, 2, 2},
                {3, 3, 3, 3}};
        int[][] secondArray = {
                {3, 3, 3, 3},
                {4, 4, 4, 4}};
        int[][] resultArray = {
                {5, 5, 5, 5},
                {7, 7, 7, 7}};
        Matrix firstMatrix = new ArrayToMatrixConverter().converter(firstArray);
        Matrix secondMatrix = new ArrayToMatrixConverter().converter(secondArray);
        Matrix resultMatrix = firstMatrix.add(secondMatrix);
        Assert.assertTrue(Arrays.deepEquals(new MatrixToArrayConverter().converter(resultMatrix), resultArray));
    }

    @Test
    public void testGetElement() throws Exception {
        int[][] array = {
                {2, 3, 4, 5},
                {2, 3, 4, 9},
                {8, 8, 1, 8},
                {4, 3, 4, 3}};
        Matrix matrix = new ArrayToMatrixConverter().converter(array);
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
        Matrix matrix = new ArrayToMatrixConverter().converter(left);
        matrix.setElement(23, 0, 0);
        Assert.assertTrue(Arrays.deepEquals(new MatrixToArrayConverter().converter(matrix), result));
    }

    @Test
    public void testMultiply() throws Exception {
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
        Matrix leftMatrix = new ArrayToMatrixConverter().converter(left);
        Matrix rightMatrix = new ArrayToMatrixConverter().converter(right);
        Matrix resultMatrix = leftMatrix.multiply(rightMatrix);

        Assert.assertTrue(Arrays.deepEquals(new MatrixToArrayConverter().converter(resultMatrix), result));
    }

    @Test
    public void testClone() throws Exception {
        int[][] array = {
                {2, 3, 4, 5},
                {2, 3, 4, 9},
                {8, 8, 1, 8},
                {4, 3, 4, 3}};
        Matrix matrix = new ArrayToMatrixConverter().converter(array);
        Matrix clone = matrix.clone();
        matrix.setElement(2, 0, 1);

        Assert.assertEquals(clone.getElement(0, 1), clone.getElement(0, 1));
    }

}
