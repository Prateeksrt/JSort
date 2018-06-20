package com.srt.sort;

import java.util.Arrays;

public class Utils {
    public static <T> void print(T[] array){
        Arrays.stream(array).forEach( item -> System.out.print(item + " "));
        System.out.println();
    }

    public static <T> void printTree(T[] array, int length){
        int level = level(length);
        int x = 0;
        for (int i = 0; i <= level; i++) {
            int numberOfEle = ((int) Math.pow(2, i));
            int numberOfSpace = ((int) Math.pow(2, level - i));
            while(numberOfEle!=0 && x < length){
                printSpace(numberOfSpace);
                System.out.print(array[x++]);
                printSpace(numberOfSpace - 1);
                numberOfEle--;
            }
            System.out.print("\n");
        }
    }

    private static void printSpace(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    private static int level(int length){
        return ((int) Math.floor(Math.log(length) / Math.log(2)));
    }
}