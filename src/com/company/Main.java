package com.company;

import java.util.Random;
import java.util.function.BiFunction;

public class Main {
    public static void printArray(int[] sortedData, int size){
        for(int i=0; i<size;++i){
            System.out.print(sortedData[i] + " ");
        }
        System.out.println();
    }

    public static void testSort(int[] array, int size, BiFunction<int [], Integer, SortMetrics> sortOperation) {
        // print unsorted data
        printArray(array,size);
        // clone array
        int[] sortme = array.clone();
        // set start time
        long startTime = System.nanoTime();
        // sort data
        SortMetrics metrics = sortOperation.apply(sortme, size);
        // get stop time (and elapsed)
        long stopTime = System.nanoTime();
        // print sorted data
        printArray(sortme,size);
        // print metrics
        System.out.println(metrics);
        // print time
        System.out.println("Sort took " + (stopTime-startTime) + "ns");
    }

    public static int[] generateRandomArray(int count, int max){
        int[] list = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++)
        {
            list[i] = random.nextInt(max);
        }
        return list;
    }

    public static void main(String[] args) {
	// write your code here
        int[] randomArray = generateRandomArray(10,100);
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));

    }
}
