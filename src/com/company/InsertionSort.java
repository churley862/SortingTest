/*
 * Collin Hurley
 * 11/8/2018
 * CS 203
 * */
package com.company;

public class InsertionSort {


    public static SortMetrics InsertionSort(int[] data, int dataSize){
        int swaps = 0;
        int comparisons = 0;
        for(int i=1; i<(dataSize);i++){
            int key = data[i];
            int previousIndex = i-1;
            while ( (previousIndex>=0) && (data[previousIndex] > key) ){
                comparisons += 2;
                data[previousIndex+1] = data[previousIndex];
                ++swaps;
                previousIndex--;
            }
            data[previousIndex+1] = key;

        }

        return new SortMetrics(swaps, comparisons);

    }
}



