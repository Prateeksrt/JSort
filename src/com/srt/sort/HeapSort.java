package com.srt.sort;

import java.util.Arrays;
import java.util.function.BiFunction;

public class HeapSort<T extends Comparable> extends JSort<T>{


    private T[] buildHeap(T[] array, BiFunction<T, T, Boolean> compare) {
        for (int i = array.length/2; i >= 0; i--) {
            heapify(array, compare, i, array.length - 1);
        }
        return array;
    }

    private void heapify(T[] array, BiFunction<T, T, Boolean> compare, int index, int length) {
        int childIndex = (right(index)) < length
                ? childIndex(array, compare, index)
                : left(index);
        if (compare.apply(array[childIndex], array[index])){
            swap(array, index, childIndex);
            if (childIndex < (length)/2)
                heapify(array, compare, childIndex, length);
        }
    }

    private int childIndex(T[] array, BiFunction<T, T, Boolean> compare, int index) {
        return compare.apply(array[left(index)], array[right(index)])
                ? left(index)
                : right(index);
    }

    private int right(int index) {
        return index * 2 + 1;
    }

    private int left(int index) {
        return index * 2;
    }

    private void swap(T[] array, int index, int childIndex) {
        T temp = array[index];
        array[index] = array[childIndex];
        array[childIndex] = temp;
    }

    @Override
    T[] Sort(T[] array, BiFunction<T, T, Boolean> compare) {
        T[] heap = buildHeap(array, compare);
        T[] sorted = Arrays.copyOf(array, array.length);
        int length = array.length;
        for (int i = 0; i < array.length; i++) {
            sorted[i] = heap[0];
            swap(heap, 0, length-1);
            heapify(heap, compare, 0, length-1);
            length -= 1;
        }
        return sorted;
    }
}
