package com.day16;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class PrimeNumbersRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the range: ");
        System.out.print("Start: ");
        int start = scanner.nextInt();
        System.out.print("End: ");
        int end = scanner.nextInt();

        System.out.println();

        System.out.println("Prime numbers in range (" + start + "-" + end + "): ");
        primeNumbers(start,end);
    }

    public static void primeNumbers(int start, int end){
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> anagram = new LinkedList<>();
        LinkedList<Integer> palindrome = new LinkedList<>();
        for (int i=start;i<=end;i++) {
            int j;
            for(j=2;j<i;j++){
                if(i%j == 0){
                    break;
                }
            }
            if(i==j){
                list.add(i);
            }
        }
        System.out.println(list);

        System.out.println();

        System.out.println("The prime numbers that are anagram:");
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if (isAnagram(list.get(i), list.get(j))){
                    anagram.add(list.get(i));
                    anagram.add(list.get(j));
                }
            }
        }
        System.out.println(anagram);

        System.out.println();

        System.out.println("The prime numbers that are palindrome:");
        for (Integer integer : list) {
            if (isPalindrome(integer)) {
                palindrome.add(integer);
            }
        }
        System.out.println(palindrome);

    }

    private static boolean isPalindrome(Integer num) {
        String str = Integer.toString(num);
        char[] arr1 = str.toCharArray();
        char[] arr2 = new char[arr1.length];
        int j = 0;

        for (int i=arr1.length-1;i>=0;i--){
            arr2[j] = arr1[i];
            j++;
        }

        return  Arrays.equals(arr1,arr2);
    }

    public static boolean isAnagram(Integer num1, Integer num2){
        String str1 = Integer.toString(num1);
        String str2 = Integer.toString(num2);

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1,arr2);
    }
}
