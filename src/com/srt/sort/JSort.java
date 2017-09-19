package com.srt.sort;

import java.util.function.BiFunction;

@SuppressWarnings("unchecked")
public abstract class JSort<T extends Comparable> implements Sort<T> {

    abstract T[] Sort(T[] array, BiFunction<T, T, Boolean> compare);

    @Override
    public T[] sortAscending(T[] array) {
        return Sort(array, (a,b) -> a.compareTo(b) < 0);
    }

    @Override
    public T[] sortDescending(T[] array) {
        return Sort(array, (a,b) -> a.compareTo(b) > 0);
    }
}
