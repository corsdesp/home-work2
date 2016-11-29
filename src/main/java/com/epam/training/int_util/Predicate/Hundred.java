package com.epam.training.int_util.Predicate;

public class Hundred implements Predicate{
    @Override
    public boolean check(int value) {
        return value >= 100;
    }
}
