/*
 * Collin Hurley
 * 11/8/2018
 * CS 203
 * */
package com.company;

public class QuickSort {
    private static int comparisons = 0;
    private static int swaps = 0;
    public static SortMetrics QuickSort(int data[], int dataSize){
        int left =0;
        int right = dataSize-1;
        quickSort(data,left,right);
        return new SortMetrics(swaps,comparisons);
    }

    private static void quickSort(int[] data, int left, int right) {
        comparisons++;
        if(left >= right){
            return;
        }
        int pivot = data[(left + right)/2];
        int index = partition(data,left,right,pivot);
        quickSort(data,left,index-1);
        quickSort(data,index,right);

    }

    private static int partition(int[] data, int left, int right, int pivot) {
        comparisons++;
        while (left<=right){
            comparisons++;
            while (data[left]< pivot){
                left++;
            }
            comparisons++;
            while (data[right]>pivot){
                right--;
            }
            comparisons++;
            if(left <=right){
                swaps++;
                swap(data,left,right);
                left++;
                right--;

            }

        }
        return left;
    }

    private static void swap(int[] data, int left, int right) {
        int temp =data[left];
        data[left] = data[right];
        data[right] = temp;

    }
}
