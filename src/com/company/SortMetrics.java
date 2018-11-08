/*
 * Collin Hurley
 * 11/8/2018
 * CS 203
 * */
package com.company;

public class SortMetrics {
    private int swaps;
    private int comparisons;

        /************************************************************/
        /* Method: getSwaps */
        /* Purpose: getter for the swaps variable
        /* Parameters: none */
        /* Returns: int swaps: number of swaps*/
        /**************************************************************/
    public int getSwaps() {
        return swaps;
    }

        /************************************************************/
        /* Method: getComparisons */
        /* Purpose: getter for the comparisons variable
        /* Parameters: none */
        /* Returns: int comparisons: number of comparisons*/
        /**************************************************************/
    public int getComparisons() {
        return comparisons;
    }
    /*****************************************************************/
    /* Method: SortMetrics */
    /* Purpose: constructor that creates an instance of sort metrics
    /* storing the values of the swaps and comparisons for return
    /* Parameters: */
    /* int swaps: number of swaps*/
    /* int comparisons: number of comparisons*/
    /* Returns: an instance of the SortMetrics Class*/
    /*****************************************************************/
    public SortMetrics(int swaps, int comparisons) {
        this.swaps = swaps;
        this.comparisons = comparisons;
    }

    @Override
    /************************************************************************************/
    /* Method: toString */
    /* Purpose: Overrides the toString method with one that just prints
    /* swaps and comparisons directly
    /* Parameters: none */
    /* Returns: String: string in format of Swaps: swaps Comparisons: comparisons*/
    /************************************************************************************/
    public String toString(){
        return "Swaps: " + swaps + " Comparisons:" + comparisons;
    }
}
