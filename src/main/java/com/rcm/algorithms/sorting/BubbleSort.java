package com.rcm.algorithms.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] vals = {45, 12, 9, 0, 54, 31, 49};
        sort(vals);
    }

    /**
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     * @param input
     * @return
     */
    private static int[] sort(int[] input) {
        int[] sorted = input;
        int count = input.length;
        while (count > 0) { // O(n)
            for(int x = 0; x < count-1; x++) { // O(n)
                if(sorted[x] > sorted[x+1]) {
                    int temp = sorted[x];
                    sorted[x] = sorted[x+1];
                    sorted[x+1] = temp;
                }
            }
            count--;
        }


        for(int x = 0; x < sorted.length; x++) {
            System.out.print(sorted[x] + " ");
        }

        return sorted;
    }

}
