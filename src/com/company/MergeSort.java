/*
 * Collin Hurley
 * 11/8/2018
 * CS 203
 * */
package com.company;

public class MergeSort {
    private static int comparisons = 0;
    private static int swaps = 0;
    /**************************************************************/
    /* Method: MergeSort */
    /* Purpose: Runs merge sort on the inputted array data
    /* for the size inputted, calls the recursive sort function
    /* Parameters: */
    /* int[] data: the array to be sorted */
    /* int dataSize: the size of the array to be sorted */
    /* Returns: SortMetrics: swaps and comparisons are stored here*/
    /**************************************************************/
    public static SortMetrics MergeSort(int data[], int dataSize){
        int[] temp = new int[dataSize];
        int leftStart = 0;
        int rightEnd = dataSize-1;
        sort(leftStart, rightEnd, temp, data);

        return new SortMetrics(swaps,comparisons);
    }
    /**************************************************************/
    /* Method: sort */
    /* Purpose: recurisively calls itself til split to the smallest
    /* level and then sorts it at the smallest level
    /* Parameters: */
    /* int[] data: the array to be sorted */
    /* int[] temp: single array to store results in to save time */
    /* int leftStart: start of the left side of the split array
    /* int rightEnd: end of the array on the right side
    /* Returns: SortMetrics: swaps and comparisons are stored here*/
    /**************************************************************/
    private static void sort(int leftStart, int rightEnd, int[] temp, int[] data) {
        comparisons++;
        if(leftStart < rightEnd) {
            int middle = (leftStart + rightEnd) / 2;
            sort(leftStart, middle, temp, data);
            sort(middle+1, rightEnd, temp, data);
            mergeSides(leftStart, rightEnd, temp, data);
        }
    }

    /**************************************************************/
    /* Method: mergeSides */
    /* Purpose: puts together two sides of the split array for
    /* merge sort
    /* Parameters: */
    /* int[] data: the array to be sorted */
    /* int[] temp: single array to store results in to save time */
    /* int leftStart: start of the left side of the split array
    /* int rightEnd: end of the array on the right side
    /* Returns: void */
    /**************************************************************/
    private static void mergeSides(int leftStart, int rightEnd, int[] temp , int[] data) {
        int leftEnd = (rightEnd+leftStart)/2;
        int rightStart = leftEnd + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        comparisons += 2;
        while (left <= leftEnd && right <= rightEnd) {
            comparisons++;
            if (data[left] <= data[right]){
                swaps++;
                temp[index] = data[left];
                left++;
            } else {
                swaps++;
                temp[index] = data[right];
                right++;
            }
            index++;
        }
        comparisons++;
        while(right <= rightEnd){
            temp[index] = data[right];
            swaps++;
            right++;
            index++;
        }
        comparisons++;
        while (left <= leftEnd){
            temp[index] = data[left];
            swaps++;
            left++;
            index++;
        }

        for (index = leftStart; index <= rightEnd; ++index) {
            comparisons++;
            data[index] = temp[index];
        }
    }
}

