package com.srt.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiFunction;

@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable> extends JSort<T>{

    private Class<T> clazz;

    public MergeSort(Class<T> clazz) {
        this.clazz = clazz;
    }

    private T[] merge(T[] left, T[] right, BiFunction<T, T, Boolean> compare){
        int i = 0, j = 0, k = 0;
        T[] mergedArray =  getArray(clazz, left.length + right.length );
        while(i < left.length || j < right.length){
            if(i == left.length){
                mergedArray[k++] = right[j++];
            } else if (j == right.length){
                mergedArray[k++] = left[i++];
            } else if(compare.apply(left[i], right[j])){
                mergedArray[k++] = left[i++];
            } else {
                mergedArray[k++] = right[j++];
            }
        }
        return mergedArray;
    }
    private T[] getArray(Class<T> clazz, int size){
        T[] es = (T[]) Array.newInstance(clazz, size);
        return  es;
    }

    T[] Sort(T[] array, BiFunction<T, T, Boolean> compare){
        if ( array.length == 1){
            return array;
        }
        return merge(Sort(FirstHalf(array), compare),
                Sort(secondHalf(array), compare), compare);
    }

    private T[] secondHalf(T[] array) {
        return Arrays.copyOfRange(array, array.length/2, array.length);
    }

    private T[] FirstHalf(T[] array) {
        return Arrays.copyOfRange(array, 0 , (array.length /2));
    }
}
