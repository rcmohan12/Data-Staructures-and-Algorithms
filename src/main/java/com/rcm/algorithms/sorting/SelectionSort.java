package com.rcm.algorithms.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] vals = {45, 12, 9, 0, 54, 31, 49};
        sort(vals);
    }

    /**
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     * @param vals
     * @return
     */
    private static int[] sort(int[] vals) {
        int[] sorted = vals;
        int count = 0;
        int lowest = 0;
        while (count < vals.length) { // O(n)
            lowest = sorted[count];
            int index=0;
            for(int x = count; x < vals.length; x++) { // O(n)
                if(lowest > sorted[x]) {
                    lowest = sorted[x];
                    index = x;
                }
            }
            if(index > count) {
                int temp = sorted[count];
                sorted[count] = lowest;
                sorted[index] = temp;
            }
            count++;
        }

        for(int x = 0; x < sorted.length; x++) {
            System.out.print(sorted[x] + " ");
        }

        return sorted;
    }
}
