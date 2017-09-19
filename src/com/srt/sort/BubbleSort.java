package com.srt.sort;

import java.util.Arrays;
import java.util.function.BiFunction;

public class BubbleSort<T extends Comparable> extends JSort<T> {

    T[] Sort(T[] arr, BiFunction<T, T, Boolean> compare){
        T[] array = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (compare.apply(array[j], array[j - 1])){
                    T temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }
}
