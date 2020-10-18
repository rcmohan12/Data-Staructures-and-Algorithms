package com.rcm.dataStructure.arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 22, 30, 31};
        int[] arr2 = {2, 30};
        sort(arr1, arr2);
    }

    public static void sort(int arr1[], int arr2[]) {
        int[] sortedArray = new int[arr1.length + arr2.length];

        int v1 = arr1[0];
        int index1 = 0;
        int v2 = arr2[0];
        int index2 = 0;
        int index3 = 0;
        boolean a1Updated = false;
        boolean a2Updated = false;

        while(index1 < arr1.length && index2 < arr2.length) {
            a1Updated = false;
            a2Updated = false;
            if(arr1[index1] < arr2[index2]) {
                sortedArray[index3] = arr1[index1];
                index3++;
                index1++;
                a1Updated = true;
            } else if(arr1[index1] > arr2[index2]) {
                sortedArray[index3] = arr2[index2];
                index3++;
                index2++;
                a2Updated = true;
            } else {
                sortedArray[index3] = arr1[index1];
                index3++;
                sortedArray[index3] = arr1[index1];
                index3++;
                index1++;
                index2++;
                a1Updated = true;
                a2Updated = true;
            }
        }
        if(!a1Updated) {
            sortedArray[index3] = arr1[index1];
        } if(!a2Updated) {
            sortedArray[index3] = arr2[index2];
        }
        for(int i : sortedArray) {
            System.out.print(i + " ");
        }

    }

}











