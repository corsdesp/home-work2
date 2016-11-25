package com.epam.training.int_util;

import com.epam.training.int_util.Predicate.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IntArrayUtilTest {
    @Test
    public void testEquals() throws Exception {
        assertTrue(IntArrayUtil.equals(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testEqualsWhereEmptyArray() throws Exception {
        assertFalse(IntArrayUtil.equals(new int[]{}, new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testChangeSize() throws Exception {
        int newSize = 5;
        assertArrayEquals(IntArrayUtil.changeSize(new int[]{2, 3, 4}, newSize), new int[]{2, 3, 4, 0, 0});
    }

    @Test
    public void testChangeSizeWhereSmallerSize() throws Exception {
        int newSize = 2;
        assertArrayEquals(IntArrayUtil.changeSize(new int[]{2, 3, 4}, newSize), new int[]{2, 3});
    }

    @Test
    public void testChangeSizeWhereSizeLessZero() throws Exception {
        int newSize = -1;
        int[] array = new int[]{2, 3, 4};
        assertArrayEquals(IntArrayUtil.changeSize(array, newSize), array);
    }

    @Test
    public void testShuffle() throws Exception {
        int[] first = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] second = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertFalse(Arrays.equals(IntArrayUtil.shuffle(first), second));
    }

    @Test
    public void testPrintPretty() throws Exception {
        int[] array = new int[]{6, 8, 4, 5, 0, 7, 1, 9, 10, 2, 3};
        String str = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]";
        assertTrue(IntArrayUtil.printPretty(array).equals(str));
    }

    @Test
    public void testPredicateEven() throws Exception {
        int[] array = new int[]{2, 3, 4, 5, 6};
        int[] result = new int[]{2, 4, 6};
        assertTrue(Arrays.equals(IntArrayUtil.filter(array, new Even()), result));
    }

    @Test
    public void testPredicateHundred() throws Exception {
        int[] array = new int[]{2, 100, 4, 205, 777};
        int[] result = new int[]{100, 205, 777};
        assertTrue(Arrays.equals(IntArrayUtil.filter(array, new Hundred()), result));
    }

    @Test
    public void testPredicateNegative() throws Exception {
        int[] array = new int[]{-2, 3, 0, -5, 6, -4};
        int[] result = new int[]{-2, -5, -4};
        assertTrue(Arrays.equals(IntArrayUtil.filter(array, new Negative()), result));
    }

    @Test
    public void testPredicatePositive() throws Exception {
        int[] array = new int[]{-2, 3, 0, -5, 6, -4};
        int[] result = new int[]{3, 6};
        assertTrue(Arrays.equals(IntArrayUtil.filter(array, new Positive()), result));
    }

    @Test
    public void testPredicateUneven() throws Exception {
        int[] array = new int[]{2, 3, 4, 5, 6};
        int[] result = new int[]{3, 5};
        assertTrue(Arrays.equals(IntArrayUtil.filter(array, new Uneven()), result));
    }
}
