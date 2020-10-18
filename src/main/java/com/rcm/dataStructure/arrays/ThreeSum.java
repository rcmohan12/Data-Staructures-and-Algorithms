package com.rcm.dataStructure.arrays;

import java.util.HashMap;
import java.util.Map;

public class ThreeSum {

    public static void main(String[] args) {
        bruteForce(new int[]{-1, 0, 1, 2, -1, 4}, 0);
        optimised(new int[]{-1, 0, 1, 2, -1, 4}, 0);
    }

    //O(n^3)
    private static void bruteForce(int[] a, int sum) {
        for(int x = 0; x < a.length; x ++) {
            for(int y = x; y < a.length; y++) {
                for(int z = y; z < a.length; z++) {
                    if(x!=y && x!=z) {
                        if((a[x] + a[y] + a[z]) == sum) {
                            System.out.println("Results found at: ["+a[x]+"] "+"["+a[y]+"] "+"["+a[z]+"]");
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void optimised(int[] a, int sum) {
        Map<Integer, Integer> m1 = new HashMap<>();
        //O(n)
        for(int x = 0; x < a.length; x ++) {
            m1.put(sum-a[x], x);
            System.out.println(sum-a[x] +","+ x);
        }
        //O(n * m)
        for(Map.Entry<Integer, Integer> entry : m1.entrySet()) {
            Map<Integer, Integer> compliments = new HashMap<>();
            for(int x = 0; x < a.length; x ++) {
                System.out.println(x);
                System.out.println("KK"+entry.getKey());
                System.out.println("VV"+entry.getValue());
                if( x!= entry.getValue()) {
                    if(compliments.containsKey(a[x])) {
                        System.out.println("Result found at index ["+ entry.getKey() + "] , [" + compliments.get(a[x])+"] , "+"["+a[x]+"]");
                       continue;
                    } else {
                        compliments.put((entry.getKey() - a[x]), x);
                    }
                }
            }
        }

    }

}
