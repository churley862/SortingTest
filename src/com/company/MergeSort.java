package com.company;

public class MergeSort {
    public static SortMetrics MergeSort(int data[], int dataSize){
        int swaps = 0;
        int comparisons = 0;
        int[] temp = new int[dataSize];
        int leftStart = 0;
        int rightEnd = dataSize-1;
        sort(leftStart, rightEnd,temp, data);
        System.out.println(temp[0] +" " +data[0]);
        return new SortMetrics(swaps,comparisons);
    }

    private static void sort(int leftStart, int rightEnd,int[] temp, int[] data) {
        if(leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd)/2;
        sort(leftStart,middle,temp,data);
        sort(middle+1,rightEnd,temp,data);
        mergeSides(leftStart,rightEnd,temp,data);

        }

    private static void mergeSides(int leftStart, int rightEnd,int[] temp , int[] data) {
        int leftEnd = (rightEnd+leftStart)/2;
        int rightStart = leftEnd+1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd){
            if (data[left] <= data[right]){
                temp [index] = data[left];
                left++;
            }else{
                temp[index] = data[right];
                right++;
            }
            index++;
        }
        while(right <= rightEnd){
            temp[index] = data[right];
            right++;
        }
        while (left <= leftEnd){
            temp[index] = data[left];
            left++;
        }
        data = temp.clone();

    }
}

