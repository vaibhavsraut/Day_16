package com.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringPermutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the String:");
        String string = scanner.next();

        System.out.println();

        String[] iterativePermutations = permutationsIterative(string);
        System.out.println("Iterative Permutations: " + Arrays.toString(iterativePermutations));

        String[] recursivePermutations = permutationsRecursive(string);
        System.out.println("Recursive Permutations: " + Arrays.toString(recursivePermutations));

        boolean areEqual = areArraysEqual(iterativePermutations, recursivePermutations);
        System.out.println("Are the permutations equal? " + areEqual);
    }

    public static String[] permutationsIterative(String input) {
        List<String> permutations = new ArrayList<>();
        permutations.add(""); // Initial permutation

        for (char ch : input.toCharArray()) {
            List<String> newPermutations = new ArrayList<>();
            for (String permutation : permutations) {
                for (int i = 0; i <= permutation.length(); i++) {
                    String newPermutation = permutation.substring(0, i) + ch + permutation.substring(i);
                    newPermutations.add(newPermutation);
                }
            }
            permutations = newPermutations;
        }

        return permutations.toArray(new String[0]);
    }

    public static String[] permutationsRecursive(String input) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsRecursiveHelper(input.toCharArray(), 0, permutations);
        return permutations.toArray(new String[0]);
    }

    private static void generatePermutationsRecursiveHelper(char[] arr, int index, List<String> permutations) {
        if (index == arr.length - 1) {
            permutations.add(new String(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            char temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            generatePermutationsRecursiveHelper(arr, index + 1, permutations);

            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public static boolean areArraysEqual(String[] arr1, String[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}

