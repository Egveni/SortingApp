package com.epam;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * The recursive method mergeSort divides array to smaller subarrays
 * and call for merge method who comparing subarrays
 * and merging it to one sorted array.
 */
public class SortingApp {
    static final Logger logger = Logger.getLogger(SortingApp.class);

    public static void main(String[] args) {
        int[] arr = {4,2,7,8};
        logger.info("Given array: " + Arrays.toString(arr));
        SortingApp sortingApp = new SortingApp();
        sortingApp.mergeSort(arr);
        logger.info("Sorting was finished successfully");
        sortingApp.display(arr);
    }

    public static void merge(int[] arr, int[] l, int[] r) {
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < left && j < right) {
            if (l[i] < r[j]) {
                arr[index] = l[i];
                i++;
            } else {
                arr[index] = r[j];
                j++;
            }
            index++;
        }
        for (int ll = i; ll < left; ll++) {
            arr[index++] = l[ll];
        }
        for (int rr = j; rr < right; rr++) {
            arr[index++] = r[rr];
        }
        logger.info("Comparing and merging of subarrays");
    }

    public int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            throw new NullPointerException("Array is empty");
        }
        if (n == 1) return arr;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        System.arraycopy(arr, 0, l, 0, mid);
        if (n - mid >= 0) System.arraycopy(arr, mid, r, 0, n - mid);
        logger.info("Recursive method for dividing left subarray was called");
        mergeSort(l);
        logger.info("Recursive method for dividing right subarray was called");
        mergeSort(r);
        merge(arr, l, r);
        return arr;
    }

    void display(int[] arr) {
        logger.info("Sorted Array: " + Arrays.toString(arr));
    }
}