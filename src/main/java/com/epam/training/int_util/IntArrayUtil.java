package com.epam.training.int_util;

import java.util.Arrays;
import java.util.Random;

/**
 * Утилита для массивов типа {@code int}
 */
public final class IntArrayUtil {
    public static int[] changeSize(int[] array, int size) {
        if (check(array) || size < 0) {
            return array;
        }
        return Arrays.copyOf(array, size);
    }

    public static int[] shuffle(int[] array) {
        if (check(array)) {
            return array;
        }
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, random.nextInt(i + 1));
        }
        return array;
    }

    private static void swap(int[] array, int index, int newIndex) {
        int anotherValue = array[newIndex];
        array[newIndex] = array[index];
        array[index] = anotherValue;
    }


    public static String printPretty(int[] array) {
        if (check(array)) {
            return Arrays.toString(array);
        }
        return Arrays.toString(sort(array));
    }

    private static int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public static boolean equals(int[] first, int[] second) {
        int[] copyFirst = Arrays.copyOf(first, first.length);
        int[] copySecond = Arrays.copyOf(second, second.length);
        return Arrays.equals(sort(copyFirst), sort(copySecond));
    }

    private static boolean check(int[] array) {
        return (array == null || array.length == 0);
    }
}
