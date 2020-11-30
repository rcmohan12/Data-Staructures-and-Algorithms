package com.rcm.algorithms.recursion;

public class Recursion {

    public static void main(String[] args) {
        System.out.println("Fibonacci value at 8 :"+getFiboNum(8));
    }

    /**
     * This method returns the value of the Fibonacci number at the specified index position
     * Time complexity : O(2^n)
     * @param index
     * @return
     */
    public static int getFiboNum(int index) {

        if(index < 2) {
            return index;
        }
        return getFiboNum(index-1)+getFiboNum(index-2);

    }
}
