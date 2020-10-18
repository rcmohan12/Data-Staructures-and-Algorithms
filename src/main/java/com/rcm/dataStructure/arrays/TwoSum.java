package com.rcm.dataStructure.arrays;

import sun.dc.pr.PRError;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        bruteForce(new int[]{1, 2, 3456}, 3457);
        long end = System.currentTimeMillis();
        System.out.println("Brute force time taken :"+ (end-start) + "ms");

        long start1 = System.currentTimeMillis();
        optimised(new int[]{1, 2, 3, 4, 5, 6, 7, 23, 4, 2, 5, 78, 2, 3, 3, 6, 9, 43, 2, 23, 43, 5, 3, 83, 2, 8, 4, 7, 23, 7, 23, 4, 2, 5, 43, 2, 23, 43, 5, 3, 83, 2, 8, 4, 7, 23, 7, 23, 43, 2, 23, 43, 5, 3, 83, 2, 8, 4, 7, 23, 7, 23, 4, 2, 5, 78, 2, 3, 3, 6, 9, 43, 2, 23, 43, 5, 3, 83, 4, 2, 5, 78, 2, 3, 3, 6, 9, 43, 4, 2, 5, 78, 2, 3, 3, 6, 9, 43, 2, 23, 43, 5, 3, 83, 4, 2, 5, 78, 2, 3, 3, 6, 9, 4378, 2, 3, 3, 6, 9, 43, 2, 23, 43, 5, 3, 83, 4, 2, 5, 78, 2, 3, 3, 6, 9, 43, 2, 23, 43, 5, 3, 83,6, 89, 34, 22, 63, 58, 3456}, 3457);
        long end1 = System.currentTimeMillis();
        System.out.println("Optimised time taken :"+ (end1-start1) + "ms");
    }

    //Time complexity o(n^2)
    private static void bruteForce(int[] arr, int sum) {
        int check = 0;
        for(int x = 0; x < arr.length; x++) {
            for(int y = 0; y < arr.length; y++) {
                if(x!=y) {
                    check = arr[x] + arr[y];
                    if(check == sum) {
                        System.out.println("Result found at index ["+ x + "] and [" + y+"]");
                        return;
                    }
                }

            }
        }
        System.out.println("Result not found. ");
    }

    //Time complexity o(n)
    private static void optimised(int[] arr, int sum) {
        Map<Integer, Integer> compliments = new HashMap<>();
        for(int x = 0; x < arr.length; x ++) {
            if(compliments.containsKey(arr[x])) {
                System.out.println("Result found at index ["+ compliments.get(arr[x]) + "] and [" + x+"]");
                return;
            } else {
                compliments.put((sum - arr[x]), x);
            }
        }
        System.out.println("Result not found. ");
    }

}
