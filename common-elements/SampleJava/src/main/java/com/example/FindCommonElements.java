package com.example;
/**
 * Sample Java exercise to find common elements between randomly generate arrays.
 *
 * @author jdanado
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Class To find common elements
 */
public class FindCommonElements {

    /**
     * Main execution method.
     *
     * Steps:
     * - Generate numbers for 2 arrays of different size
     * - Sort both arrays
     * - Find common elements
     * @param args No arguments required
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Initial arrays
        int[] array1 = new int[30];
        int[] array2 = new int[40];

        insertRandomNumbers(array1);
        insertRandomNumbers(array2);

        //show values
        printArray(array1);
        printArray(array2);
        //Lets start
        //Sort arrays in ascending order.
        // Quicksort is used in Java for primitive types and data is assumed to be unknown.
        // Other sorting algorithms may perform better if repetitions occur (e.g., 3-way Dijkstra)
        sortArray(array1);
        sortArray(array2);

        //Get common values
        ArrayList arr = getCommon(array1, array2);
        //Print result
        printResults(arr);
    }
    /**
     * Populates an int array with random numbers
     *
     * @param arr Array to be populated
     */
    public static void insertRandomNumbers(int[] arr) {
        // Random generator
        Random rand = new Random();

        // Pre-populate arrays
        for(int i=0;i< arr.length; i++) {
            arr[i] = rand.nextInt(10);
        }
    }
    /**
     * Sorts an array of ints using quicksort. The result is returned within the same array.
     * Complexity is O(N*LN) average
     *
     * @param arr array to be sorted
     */
    public static void sortArray(int[] arr) {
        Arrays.sort(arr);
    }
    /**
     * Calculates common elements between two arrays
     *
     * @param arr1 Array of int
     * @param arr2 Array of int
     * @return an ArrayList with common elements
     */
    public static ArrayList<Integer> getCommon(int[] arr1, int[] arr2) {
        ArrayList<Integer> common = new ArrayList<Integer>();
        int j=0,k=0;
        while(j < arr1.length && k < arr2.length) {
            // if number at j is less than number at k advance j
            if(arr1[j] < arr2[k])
                j++;
                // if both numbers are equal
            else if(arr1[j] == arr2[k]) {
                int last = 0;
                if(!common.isEmpty())
                    last = common.get(common.size() -1).intValue();
                //ignore if the number was already added
                if(common.isEmpty() || (!common.isEmpty() && arr1[j] != last && arr2[k] != last)) {
                    common.add(new Integer(arr1[j]));
                }
                j++;
                k++;
            }
            else {
                k++;
            }
        }
        return common;
    }
    /**
     * Print values in an array
     *
     * @param arr Array to display
     */
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for(int i=0; i< arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        if(arr.length> 0)
            System.out.print(arr[arr.length - 1]);
        System.out.println(" ]");
    }
    /**
     * Print results from an ArrayList
     *
     * @param al Array List
     */
    public static void printResults(ArrayList al) {
        System.out.print("[ ");
        for(int i=0; i< al.size() - 1; i++) {
            System.out.print(al.get(i) + ", ");
        }
        if(!al.isEmpty())
            System.out.print(al.get(al.size() - 1));
        System.out.println(" ]");
    }

}