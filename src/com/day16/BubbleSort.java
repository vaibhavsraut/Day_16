package com.day16;

import java.util.Arrays;
import java.util.Scanner;



public class BubbleSort {

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
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
