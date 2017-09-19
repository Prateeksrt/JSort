package com.srt.sort;

import java.util.Arrays;
import java.util.function.BiFunction;

@SuppressWarnings("unused")
public class SelectionSort<T extends Comparable> extends JSort<T>{
    @Override
    T[] Sort(T[] array, BiFunction<T, T, Boolean> compare) {
        T[] arr = Arrays.copyOf(array, array.length);
        for (int i = 0; i < arr.length - 1; i++) {
            T key = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if(compare.apply(arr[j], key)){
                    key = arr[j];
                    index = j;
                }
            }
            T temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
