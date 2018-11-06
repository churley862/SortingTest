package com.company;

public class InsertionSort {
    public static SortMetrics InsertionSort(int data[], int dataSize){
        return new SortMetrics(0,0);
//        int swaps = 0;
//        int comparisons = 0;
//
//        for(int i=1; i<dataSize;++i){
//            int key = data[i];
//
//            while (i>-1 && (data[i] > key)){
//                data[i+1] = data[i];
//                ++swaps;
//                i--;
//            }
//            data[i+1] = key;
//        }
//        return new SortMetrics(swaps, comparisons);
    }

}
