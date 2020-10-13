package com.rcm.dataStructure.arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 13, 22};
        int[] arr2 = {2, 7, 11, 12, 30};
        sort(arr1, arr2);








    }

    public static void sort(int arr1[], int arr2[]) {
        int[] sortedArray = new int[arr1.length + arr2.length];

        int v1 = arr1[0];
        int index1 = 0;
        int v2 = arr2[0];
        int index2 = 0;
        int index3 = 0;

        while(index1 < arr1.length && index2 < arr2.length) {
            if(arr1[index1] < arr2[index2]) {
                sortedArray[index3] = arr1[index1];
                index3++;
                index1++;
            } else if(arr1[index1] > arr2[index2]) {
                sortedArray[index3] = arr2[index2];
                index3++;
                index2++;
            } else {
                sortedArray[index3] = arr1[index1];
                index3++;
                sortedArray[index3] = arr1[index1];
                index3++;
                index1++;
                index2++;
            }
        }
        for(int i : sortedArray) {
            System.out.print(i + " ");
        }
    }

    public static void increment() {

    }

}
