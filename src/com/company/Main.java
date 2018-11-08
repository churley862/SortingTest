/*
 * Collin Hurley
 * 11/8/2018
 * CS 203
 * */
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
        //printArray(array,size);
        // clone array
        int[] sortme = array.clone();
        // set start time
        long startTime = System.nanoTime();
        // sort data
        SortMetrics metrics = sortOperation.apply(sortme, size);
        // get stop time (and elapsed)
        long stopTime = System.nanoTime();
        // print sorted data
        // printArray(sortme,size);
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
    public static int[] generateSortedArray(int count, int max){
        int[] list = new int[count];

        for (int i = 0; i < count; i++)
        {
            list[i] = i;
        }
        return list;
    }
    public static int[] generateReverseSortedArray(int count, int max){
        int[] list = new int[count];

        for (int i = 0; i < count; i++)
        {
            list[i] = count-i;
        }
        return list;
    }



    public static void main(String[] args) {
	// write your code here
        System.out.println("Test1: 1000 Elements");
        int[] randomArray = generateRandomArray(1000,100);
        System.out.print("Insertion Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        System.out.print("Merge Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        System.out.print("Quick Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));
        System.out.println();
        // Test 2
        System.out.println("Test2: 10000 Elements");
        randomArray = generateRandomArray(10000,100);
        System.out.print("Insertion Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        System.out.print("Merge Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        System.out.print("Quick Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));
        System.out.println();
        //test 3
        System.out.println("Test3: 50000 Elements");
        randomArray = generateRandomArray(50000,100);
        System.out.print("Insertion Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        System.out.print("Merge Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        System.out.print("Quick Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));
        System.out.println();

        // test 4 sorted data 50000
        System.out.println("Test4: 50000 Elements sorted");
        generateSortedArray(50000,100);
        System.out.print("Insertion Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        System.out.print("Merge Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        System.out.print("Quick Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));
        System.out.println();

        // test 5 reverse sorted data
        System.out.println("Test5: 50000 Elements reverse sorted");
        generateReverseSortedArray(50000,100);
        System.out.print("Insertion Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        System.out.print("Merge Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        System.out.print("Quick Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));
        System.out.println();





    }
}
