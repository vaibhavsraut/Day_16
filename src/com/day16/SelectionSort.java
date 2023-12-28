package com.day16;

import java.util.Arrays;
import java.util.Scanner;



public class SelectionSort {

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
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i=0;i<n-1;i++){
            int min = i;
            for (int j=i+1;j<n;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
