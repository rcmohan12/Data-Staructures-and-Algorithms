package com.rcm.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] vals = {45, 12, 9, 0, 54, 31, 49};

        System.out.println(7/2);
        int[] res = mergeSort(vals);

        for(int x = 0; x < res.length; x++) {
            System.out.print(res[x] + " ");
        }
    }

    /**
     * Time complexity - O(n log n)
     * @param vals
     * @return
     */

    public static int[] mergeSort(int[] vals) {
        int[] sorted = vals;
        if(vals.length == 1) {
            return vals;
        }
        int n = vals.length;
        int[] left = Arrays.copyOfRange(vals, 0, (n + 1)/2);
        int[] right = Arrays.copyOfRange(vals, (n + 1)/2, n);

        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int count = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if(left[leftIndex] < right[rightIndex]) {
                merged[count] = left[leftIndex];
                leftIndex++;
                count++;
            } else {
                merged[count] = right[rightIndex];
                rightIndex++;
                count++;
            }
        }

       /* while (leftIndex < left.length) {
            while (rightIndex < right.length) {
                if((leftIndex >= left.length) || left[leftIndex] > right[rightIndex]) {
                    merged[count] = right[rightIndex];
                    rightIndex++;
                    count++;
                } else {
                    merged[count] = left[leftIndex];
                    leftIndex++;
                    count++;
                }
                continue;
            }
            if(leftIndex < left.length) {
                merged[count] = left[leftIndex];
                leftIndex++;
                count++;
            }
        }*/
        return merged;
    }

}
