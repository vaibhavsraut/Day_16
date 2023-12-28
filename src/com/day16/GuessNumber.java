package com.day16;

import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N (2^n): ");
        int n = scanner.nextInt();

        int low = 0;
        int high = (int) Math.pow(2, n) - 1;

        System.out.println("Think of a number between 0 and " + high);

        int guess = guessNumber(low, high, scanner);

        System.out.println("The final answer is: " + guess);

        scanner.close();
    }

    private static int guessNumber(int low, int high, Scanner scanner) {
        if (low == high) {
            return low;
        }

        int mid = (low + high) / 2;

        System.out.print("Is the number between " + low + " and " + mid + " inclusive? (true/false): ");
        boolean isBetween = scanner.nextBoolean();

        if (isBetween) {
            return guessNumber(low, mid, scanner);
        } else {
            return guessNumber(mid + 1, high, scanner);
        }
    }
}