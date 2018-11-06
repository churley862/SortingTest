package com.company;

public class MergeSort {
    private int [] sortedData;
    private int swaps;
    private int comparisons;
    private int time;

    public void MergeSort(int data[], int dataSize){


    }
    public int[] getSortedData(){
        return sortedData;
    }
    public void setSortedData(int[] newSortedData){
        sortedData = newSortedData;
    }
    public void printArray(int[] sortedData){
        for(int i=1; i<sortedData.length;++i){
            System.out.print(sortedData[i] + " ");
        }
    }
}
