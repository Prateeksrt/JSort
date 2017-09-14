package com.srt.sort;

import java.util.Arrays;

public class Utils {
    public static <T> void print(T[] array){
        Arrays.stream(array).forEach( item -> System.out.print(item + " "));
        System.out.println();
    }
}
