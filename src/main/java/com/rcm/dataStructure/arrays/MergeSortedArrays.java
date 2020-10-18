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
        boolean run = true;

        while (v1 != -1 && v2 != -1) {

            if (v1 < v2) {
                if (v1 == -1) {
                    sortedArray[index3] = v2;
                    index2 += 1;
                    index3 += 1;
                    if (index2 < arr2.length) {
                        v2 = arr2[index2];
                    } else {
                        v2 = -1;
                    }
                } else {
                    sortedArray[index3] = v1;
                    index1 += 1;
                    index3 += 1;
                    if (index1 < arr1.length) {
                        v1 = arr1[index1];
                    } else {
                        v1 = -1;
                    }
                }

            } else if (v1 > v2) {
                if (v2 == -1) {
                    sortedArray[index3] = v1;
                    index1 += 1;
                    index3 += 1;
                    if (index1 < arr1.length) {
                        v1 = arr1[index1];
                    } else {
                        v1 = -1;
                    }
                } else {
                    sortedArray[index3] = v2;
                    index2 += 1;
                    index3 += 1;
                    if (index2 < arr2.length) {
                        v2 = arr2[index2];
                    } else {
                        v2 = -1;
                    }
                }

            } else {
                sortedArray[index3] = v1;
                index3 += 1;
                sortedArray[index3] = v2;
                index3 += 1;
                index1 += 1;
                index2 += 1;
                if (index1 < arr1.length) {
                    v1 = arr1[index1];
                } else {
                    v1 = -1;
                }
                if (index2 < arr2.length) {
                    v2 = arr2[index2];
                } else {
                    v2 = -1;
                }
            }
        }

        /*while(index1 < arr1.length && index2 < arr2.length) {
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
                index1++;
                a1Updated = true;
                sortedArray[index3] = arr1[index1];
                index3++;
                index2++;
                a2Updated = true;
            }
        }
        if(!a1Updated) {
            sortedArray[index3] = arr1[index1];
            index3++;
        }
        if(!a2Updated) {
            sortedArray[index3] = arr2[index2];
            index3++;
        }*/
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }
}











