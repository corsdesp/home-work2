package com.epam.training.int_util.Predicate;

public class Uneven implements Predicate{
    @Override
    public boolean check(int value) {
        return value % 2 != 0;
    }
}
