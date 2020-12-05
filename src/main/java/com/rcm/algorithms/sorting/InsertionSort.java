package com.rcm.algorithms.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] vals = {45, 12, 9, 0, 54, 31, 49};
        sort(vals);
    }

    /**
     * Time complexity - O(n^2)  ******could be close to O(n) if the list is almost sorted
     * Space complexity - O(1)
     * @param vals
     * @return
     */
    private static int[] sort(int[] vals) {
        int[] sorted = vals;
        for(int i = 1; i < sorted.length; i++) { //O(n)
            if(sorted[i] < sorted[i-1]) {
                for(int j = i; j >= 0; j--) { //O(n)
                    if(j == 0) {
                        break;
                    } else if(sorted[j] < sorted[j-1]) {
                        int temp = sorted[j-1];
                        sorted[j-1] = sorted[j];
                        sorted[j] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        for(int x = 0; x < sorted.length; x++) {
            System.out.print(sorted[x] + " ");
        }
        return sorted;
    }

}
