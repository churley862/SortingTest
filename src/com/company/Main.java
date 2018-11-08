/*
 * Collin Hurley
 * 11/8/2018
 * CS 203
 * */
package com.company;

import java.util.Random;
import java.util.function.BiFunction;

public class Main {
    /**************************************************************/
    /* Method: printArray */
    /* Purpose: To print an inputted array in order for debug
    /* Parameters: */
    /* int[] data: the inputted array
    /* int size: The size of the inputted array */
    /* Returns: void */
    /**************************************************************/

    public static void printArray(int[] data, int size){
        for(int i=0; i<size;++i){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    /**************************************************************/
    /* Method: testSort */
    /* Purpose: Takes in the array, its size, and the sorting
    /* algorithm to run on it and sorts it returning the time,
    /* swaps, and comparisons it took to sort
    /* Parameters: */
    /* int[] array: the inputted array
    /* int size: The size of the inputted array */
    /* BiFunction<int[], Integer, SortMetrics> sortOperation:
        bifunction takes in two parameters, an array to sort and
        the number of elements and returns a Sort metrics with swaps
        and comparisons
    /* Returns: void */
    /**************************************************************/
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
    /**************************************************************/
    /* Method: generateRandomArray */
    /* Purpose: To create an array of random integers to test
    /* Parameters: */
    /* int count: the size of the array to output
    /* int max: The max value of the array generated */
    /* Returns: int[]: randomArray */
    /**************************************************************/
    public static int[] generateRandomArray(int count, int max){
        int[] list = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++)
        {
            list[i] = random.nextInt(max);
        }
        return list;
    }
    /**************************************************************/
    /* Method: generateSortedArray */
    /* Purpose: To create an array of ordered integers to test
    /* our sorting algorithm implementations
     */
    /* Parameters: */
    /* int count: the size of the array to output
    /* Returns: int[]: sortedArray */
    /**************************************************************/
    public static int[] generateSortedArray(int count){
        int[] list = new int[count];

        for (int i = 0; i < count; i++)
        {
            list[i] = i;
        }
        return list;
    }
    /**************************************************************/
    /* Method: generateReverseSortedArray */
    /* Purpose: To create an array of reverse ordered integers
    /* to test our sorting algorithm implementations
    /* Parameters: */
    /* int count: the size of the array to output
    /* Returns: int[]: sortedArray */
    /**************************************************************/
    public static int[] generateReverseSortedArray(int count, int max){
        int[] list = new int[count];

        for (int i = 0; i < count; i++)
        {
            list[i] = count-i;
        }
        return list;
    }


    /**************************************************************/
    /* Method: Main */
    /* Purpose: To test my implementations of sorting
    /* methods, insertion sort, merge sort, and quicksort
    /* and how the data affects them
    /* Parameters: */
    /* String (args): Not used*/
    /* Returns: void */
    /**************************************************************/

    public static void main(String[] args) {
	// write your code here
        System.out.println("Test1: 1000 Elements");
        int[] randomArray = generateRandomArray(1000,1000000);
        System.out.print("Insertion Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        System.out.print("Merge Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        System.out.print("Quick Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));
        System.out.println();
        // Test 2
        System.out.println("Test2: 10000 Elements");
        randomArray = generateRandomArray(10000,1000000);
        System.out.print("Insertion Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        System.out.print("Merge Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        System.out.print("Quick Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));
        System.out.println();
        //test 3
        System.out.println("Test3: 50000 Elements");
        randomArray = generateRandomArray(50000,1000000);
        System.out.print("Insertion Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        System.out.print("Merge Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        System.out.print("Quick Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));
        System.out.println();

        // test 4 sorted data 50000
        System.out.println("Test4: 50000 Elements sorted");
        randomArray = generateSortedArray(50000);
        System.out.print("Insertion Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        System.out.print("Merge Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        System.out.print("Quick Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));
        System.out.println();

        // test 5 reverse sorted data
        System.out.println("Test5: 50000 Elements reverse sorted");
        randomArray = generateReverseSortedArray(50000,1000000);
        System.out.print("Insertion Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> InsertionSort.InsertionSort(array, size));
        System.out.print("Merge Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> MergeSort.MergeSort(array, size));
        System.out.print("Quick Sort: ");
        testSort(randomArray,randomArray.length,(array,size)-> QuickSort.QuickSort(array, size));
        System.out.println();



    }
}
