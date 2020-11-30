package com.rcm.algorithms.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] vals = {45, 12, 9, 0, 54, 31, 49};
        sort(vals);
    }


    private static int[] sort(int[] vals) {
        int[] sorted = vals;

        for(int i = 0; i < sorted.length; i++) {
            if(sorted[i] > sorted[i+1]) {
                for(int j = i; j >=0; j--) {
                    if()
                }
            }
        }

        return sorted;
    }

}
