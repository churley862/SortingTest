/*
 * Collin Hurley
 * 11/8/2018
 * CS 203
 * */
package com.company;

public class QuickSort {
    private static int comparisons = 0;
    private static int swaps = 0;
    /**************************************************************/
    /* Method: QuickSort */
    /* Purpose: Runs quick sort on the inputted array data
    /* for the size inputted, calls the recursive qSort sort function
    /* Parameters: */
    /* int[] data: the array to be sorted */
    /* int dataSize: the size of the array to be sorted */
    /* Returns: SortMetrics: swaps and comparisons are stored here*/
    /**************************************************************/
    public static SortMetrics QuickSort(int data[], int dataSize){
        int left =0;
        int right = dataSize-1;
        qSort(data,left,right);
        return new SortMetrics(swaps,comparisons);
    }
    /**************************************************************/
    /* Method: qSort*/
    /* Purpose: recurisively calls itself til partitioning in the
    /* middle, sorting around that and returning once fully sorted
    /* Parameters: */
    /* int[] data: the array to be sorted */
    /* int left:start of the left side of the split array */
    /* int right: index of the start of the right side of the array
    /* Returns: void */
    /**************************************************************/
    private static void qSort(int[] data, int left, int right) {
        comparisons++;
        if(left >= right){
            return;
        }
        int pivot = data[(left + right)/2];
        int index = partition(data,left,right,pivot);
        qSort(data,left,index-1);
        qSort(data,index,right);

    }
    /**************************************************************/
    /* Method: partition*/
    /* Purpose: Creates the partition and sorts around the pivot
    /* point
    /* Parameters: */
    /* int[] data: the array to be sorted */
    /* int left: single array to store results in to save time */
    /* int right: start of the left side of the split array
    /* int pivot: the point in the array everything is sorted around
    /* Returns: int partition: the point it split at */
    /**************************************************************/
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
    /**************************************************************/
    /* Method: swap*/
    /* Purpose: swaps the two elements if out of order
    /* Parameters: */
    /* int[] data: the array to be swapped */
    /* int left: the left element to compare */
    /* int right: the right element to compare
    /* Returns: void */
    /**************************************************************/
    private static void swap(int[] data, int left, int right) {
        int temp =data[left];
        data[left] = data[right];
        data[right] = temp;

    }
}
