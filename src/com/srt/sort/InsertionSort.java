package com.srt.sort;

import java.util.Arrays;
import java.util.function.BiFunction;

public class InsertionSort<T extends Comparable> implements Sort<T> {

    private T[] Sort(T[] arr, BiFunction<T,T, Boolean> compare){
        T[] array = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int index = i;
            while(index  > 0 && compare.apply(key, array[index -1])){
                array[index] = array[index - 1];
                index--;
            }
            array[index] = key;
        }
        return array;
    }

    public T[] sortAscending(T[] array){
        return Sort(array, (a, b) -> a.compareTo(b) < 0);
    }

    public T[] sortDescending(T[] array) {
        return Sort(array, (a, b) -> a.compareTo(b) > 0);
    }
}
