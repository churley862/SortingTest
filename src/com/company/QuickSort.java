package com.company;

public class QuickSort {

    public static SortMetrics QuickSort(int data[], int dataSize){
        int swaps = 0;
        int comparisons = 0;
        int[] temp = new int[dataSize];
        int left =0;
        int right = dataSize-1;
        quickSort(data,left,right);
        return new SortMetrics(swaps,comparisons);
    }

    private static void quickSort(int[] data, int left, int right) {
        if(left >= right){
            return;
        }
        int pivot = data[(left + right)/2];
        int index = partition(data,left,right,pivot);
        quickSort(data,left,index-1);
        quickSort(data,index,right);

    }

    private static int partition(int[] data, int left, int right, int pivot) {
        while (left<=right){
            while (data[left]< pivot){
                left++;
            }
            while (data[right]>pivot){
                right--;
            }
            if(left <=right){
                swap(data,left,right);
                left++;
                right--;

            }

        }
        return left;
    }

    private static void swap(int[] data, int left, int right) {
        int temp =data[left];
        //System.out.println(data[left]);
        data[left] = data[right];
        //System.out.println(data[right]);
        data[right] = temp;

    }
}
