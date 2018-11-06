package com.company;

public class InsertionSort {
    private int [] sortedData;
    private int swaps;
    private int comparisons;
    private long time;

    public void InsertionSort(int data[], int dataSize){
        long startTime = System.nanoTime();
        for(int i=1; i<dataSize;++i){
            int key = data[i];
            int previousKey = i-1;

            while (i>-1 && (data[i] > key)){
                data[i+1] = data[i];
                ++swaps;
                i--;
            }
            data[i+1] = key;
        }
        setSortedData(data);
        long endTime = System.nanoTime();
        setTime(endTime - startTime);
    }

    private void setTime(long totalTime) {
        time = totalTime;
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
