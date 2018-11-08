/*
 * Collin Hurley
 * 11/8/2018
 * CS 203
 * */
package com.company;

public class SortMetrics {
    private int swaps;
    private int comparisons;

    public int getSwaps() {
        return swaps;
    }

    public int getComparisons() {
        return comparisons;
    }

    public SortMetrics(int swaps, int comparisons) {
        this.swaps = swaps;
        this.comparisons = comparisons;
    }

    @Override
    public String toString(){
        return "Swaps: " + swaps + " Comparisons:" + comparisons;
    }
}
