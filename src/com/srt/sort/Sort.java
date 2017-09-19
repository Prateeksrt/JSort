package com.srt.sort;

@SuppressWarnings("unused")
public interface Sort<T>{
    T[] sortAscending(T[] array);

    T[] sortDescending(T[] array);
}
