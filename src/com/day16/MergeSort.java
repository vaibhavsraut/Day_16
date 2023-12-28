package com.day16;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Enter the size of list: ");
        n = scanner.nextInt();
        System.out.println("Enter the elements in list: ");
        String[] array = new String[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.next();
        }

        System.out.println("Unsorted List: ");
        System.out.println(Arrays.toString(array));

        System.out.println("Sorted List: ");
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(String[] array) {
        int length = array.length;
        if (length <= 1) {
            return;
        }
        int middle = length / 2;
        String[] leftArray = Arrays.copyOfRange(array, 0, middle);
        String[] rightArray = Arrays.copyOfRange(array, middle, length);

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);

    }

    private static void merge(String[] leftArray, String[] rightArray, String[] array) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0;
        int l = 0;
        int r = 0;

        while (l < leftSize && r < rightSize) {
            if (leftArray[l].compareTo(rightArray[r]) < 0) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
