package com.day16;

import java.util.Arrays;
import java.util.Scanner;



public class InsertionSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Enter the size of list: ");
        n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements in list: ");
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Unsorted List: ");
        System.out.println(Arrays.toString(arr));

        System.out.println("Sorted List: ");
        insertionSort(arr);
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for (int i=1;i<n;i++){
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
